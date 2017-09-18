package main;

import java.util.ArrayList;
import java.util.List;

import menu.GoBackMenuItem;
import menu.IndexedMenu;
import menu.MenuItem;
import menu.MenuResult;

import org.apache.commons.lang3.StringUtils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import common.SshSession;
import common.config.LogEnvironment;
import common.config.LogLogger;
import common.config.LogServer;

public class LogServerMenu extends IndexedMenu{

	private LogEnvironment logEnvironment;
	public LogServerMenu(LogEnvironment logEnvironment) {
		super("Select Server");
		this.logEnvironment = logEnvironment; 
		addServers();
		// TODO Auto-generated constructor stub
	}

	private void addServers(){
		for(LogServer server:logEnvironment.getServers()){
			MenuItem menuItem = new MenuItem(server.getName(), server.getHostNameOrIp());
			addMenuItem(menuItem);
		}
		addMenuItem(new MenuItem("all", "ALL"));
		addMenuItem(new GoBackMenuItem());
		
	}

	private List<LogServer> find(String key){
		List<LogServer> logServers = new ArrayList<LogServer>();
		for(LogServer server:logEnvironment.getServers()){
			if(StringUtils.equalsAnyIgnoreCase(key, "all")|| StringUtils.equalsAnyIgnoreCase(key, server.getName())){
				logServers.add(server);
			}
		}
		return logServers;
	}

	public MenuResult displayMenu() {
		MenuResult menuresult = super.displayMenu();
		if(!menuresult.isGoBack()){
			List<LogServer> servers = find(menuresult.getKey());
			processServers(servers); 
		}
		return menuresult;
	}
	private SshSession loginServer(LogServer server){
		String password = server.getPassword();
		if(server.isPromptPassword()){
			ServerCredentialMenu serverCredentialMenu = new ServerCredentialMenu(server.getName());

			MenuResult result = serverCredentialMenu.displayMenu();
			password = result.getKey();
		}
		JSch jsch = new JSch();
		try {
			Session session = jsch.getSession(server.getUserName(), server.getHostNameOrIp(), server.getPort());
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(password);
			session.connect();
			return new SshSession(session,server);

		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private void processServers(List<LogServer> servers){
		List<SshSession> sshSessions = new ArrayList<SshSession>();
		for(LogServer server:servers){
			SshSession session = loginServer(server);
			sshSessions.add(session);
		}
		LogServer first = servers.get(0);
		LoggerLogMenu loggerLogMenu = new LoggerLogMenu(first);
		List<LogLogger> loggers = loggerLogMenu.getLoggers(); 
		
	}

}
