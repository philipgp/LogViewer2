package common;

import com.jcraft.jsch.Session;
import common.config.LogServer;

public class SshSession {
	Session session;
	LogServer logServer;
	public SshSession(Session session, LogServer logServer) {
		super();
		this.session = session;
		this.logServer = logServer;
	}

	public boolean matchesServer(LogServer logServer){
		return this.logServer.equals(logServer);
	}
	
}
