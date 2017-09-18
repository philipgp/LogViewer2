package org.logviewer.controller;

import com.jcraft.jsch.Session;
import common.SshSession;
import common.config.LogServer;
import org.junit.Test;
import org.logviewer.controller.SessionStore;
import org.logviewer.response.ToLoginServer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by philip on 27/5/17.
 */
public class SessionStoreTest {
    @Test
    public void login() throws Exception {
        SessionStore sessionStore = new SessionStore();
        ToLoginServer loginServer = new ToLoginServer();
        loginServer.setHostName("localhost");
        loginServer.setLoggerName("locallog");
         loginServer.setUserName("test");
         loginServer.setPassword("mytpas123");
//mytpas123
        sessionStore.login(loginServer);
    }

    @Test
    public void findMatchingSessions() throws Exception {
        SessionStore sessionStore = new SessionStore();
        List<ToLoginServer> servers = new ArrayList<>();
        ToLoginServer server1 = new ToLoginServer();
        servers.add(server1);
        server1.setHostName("hostname1");
        server1.setLoggerName("logger");
        List<ToLoginServer> result = sessionStore.findMatchingSessions(servers);
        assertNotNull(result);
        assertEquals(1,result.size());
    }

    @Test
    public void findMatchingSessions2() throws Exception {
        SessionStore sessionStore = new SessionStore();
        LogServer logserv = new LogServer();
        Session jsession = null;
        logserv.setName("logger");
        logserv.setName("hostname1");
        SshSession session = new SshSession(jsession, logserv);
        
        sessionStore.addSession(session);
        List<ToLoginServer> servers = new ArrayList<>();
        ToLoginServer server1 = new ToLoginServer();
        servers.add(server1);
        server1.setHostName("hostname1");
        server1.setLoggerName("logger");
        List<ToLoginServer> result = sessionStore.findMatchingSessions(servers);
        assertNotNull(result);
        assertEquals(0,result.size());
    }

}