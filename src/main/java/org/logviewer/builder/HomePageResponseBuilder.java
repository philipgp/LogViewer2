package org.logviewer.builder;

import common.SshSession;
import common.config.LogApplicationConfig;
import common.config.LogConfig;
import common.config.LogEnvironment;
import common.config.LogServer;
import org.logviewer.controller.SessionStore;
import org.logviewer.response.homepage.EnvironmentHomePage;
import org.logviewer.response.homepage.HomePageResponse;
import org.logviewer.response.homepage.ServerHomePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by philip on 3/6/17.
 */
public class HomePageResponseBuilder {
    private LogConfig logConfig;



    private SessionStore sessionStore;

    protected  void setLoginRequiredFlag(ServerHomePage serverHomePage){
        SshSession session = sessionStore.findSession(serverHomePage.getName(), serverHomePage.getHostNameOrIp(), serverHomePage.getUserName());
        if(session!=null){
            serverHomePage.setLoginRequired(false);
        }else
            serverHomePage.setLoginRequired(true);
    }
    protected void addServers(EnvironmentHomePage environmentHomePage,List<LogServer> servers){
        if(servers!=null){
            for(LogServer server:servers){
                ServerHomePage serverHomePage = new ServerHomePage();
                environmentHomePage.addServer(serverHomePage);
                serverHomePage.setHostNameOrIp(server.getHostNameOrIp());
                serverHomePage.setName(server.getName());
                serverHomePage.setUserName(server.getUserName());
                serverHomePage.setPassword(server.getPassword());
                serverHomePage.setPromptPassword(server.isPromptPassword());
                serverHomePage.setPromptUserName(server.isPromptUserName());
                setLoginRequiredFlag(serverHomePage);
            }
        }
    }
    protected void addLogger(LogApplicationConfig applicationResponse,List<String> loggerNames){
        applicationResponse.setLoggerNames(loggerNames);
    }
    protected void addEnvironment(LogApplicationConfig applicationResponse,
                                  List<LogEnvironment> logEnvironments){
        if(logEnvironments!=null ){

            for(LogEnvironment logEnvironment:logEnvironments){
                EnvironmentHomePage environmentHomePage = new EnvironmentHomePage();
                applicationResponse.addEnvironment(environmentHomePage);
                environmentHomePage.setName(logEnvironment.getName());
                addServers(environmentHomePage,logEnvironment.getServers());
            }
        }
    }
    protected void addApplications(HomePageResponse response){
        if(logConfig!=null && logConfig.getApplications()!=null){
            List<LogApplicationConfig> appConfigs = new ArrayList<>();
            response.setApplications(appConfigs);
            for(LogApplicationConfig application:logConfig.getApplications()){
                LogApplicationConfig applicationResponse = new LogApplicationConfig();
                appConfigs.add(applicationResponse);
                applicationResponse.setApplicationName(application.getApplicationName());
                addEnvironment(applicationResponse,application.getEnvironments());
                addLogger(applicationResponse,application.getLoggerNames());
            }
        }
    }
    public HomePageResponse buildHomepageResponse(){
        HomePageResponse response = new HomePageResponse();
        addApplications(response);
        return response;
    }

    public LogConfig getLogConfig() {
        return logConfig;
    }

    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    public SessionStore getSessionStore() {
        return sessionStore;
    }

    public void setSessionStore(SessionStore sessionStore) {
        this.sessionStore = sessionStore;
    }
}
