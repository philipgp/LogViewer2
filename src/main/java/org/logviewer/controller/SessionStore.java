package org.logviewer.controller;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import common.SshSession;
import common.config.LogServer;
import org.logviewer.response.ToLoginServer;
import org.logviewer.vo.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by philip on 27/5/17.
 */
@Service
public class SessionStore {
    private List<SshSession> sshSessionList = new ArrayList<>();

    protected void addSession(SshSession session){
        sshSessionList.add(session);
    }

    public SshSession findSession(String name,String hostName,String userName){
        LogServer logserver = new LogServer();
        logserver.setUserName(userName);
        logserver.setHostNameOrIp(hostName);
        logserver.setName(name);
        for(SshSession sshSession:sshSessionList){
            if(sshSession.matchesServer(logserver))
                return sshSession;
        }
        return null;
    }
    protected boolean hasSession(String logName,String hostname){
        LogServer logServer = new LogServer();
        logServer.setHostNameOrIp(hostname);
        logServer.setName(logName);
        for(SshSession sshSession:sshSessionList){
            return true;
        }
        return false;
    }
    public List<ToLoginServer> findMatchingSessions(List<ToLoginServer> servers){
        List<ToLoginServer> serversToLogin = new ArrayList<>();
        for(ToLoginServer server:servers){
            if(!hasSession(server.getName(),server.getHostName()))
                serversToLogin.add(server);
        }
        return serversToLogin;

    }
    public Status login(ToLoginServer server){
        JSch jsch = new JSch();
        try {
            Session session = jsch.getSession(server.getUserName(),  server.getHostName()
                    , 22);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(server.getPassword());
            session.connect();
            LogServer logServer = new LogServer();
            logServer.setName(server.getName());
            logServer.setHostNameOrIp(server.getHostName());
            logServer.setPassword(server.getPassword());
            logServer.setUserName(server.getUserName());
            SshSession sshSession = new SshSession(session, logServer);
            addSession(sshSession);

        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

}
