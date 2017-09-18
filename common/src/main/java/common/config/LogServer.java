package common.config;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LogServer {
	private String name,hostNameOrIp;
	private Integer port  = 22;
	private String userName,password;
	private boolean promptPassword = true,promptUserName = false;
	private List<LogLogger> loggers;
	private String serverLogFolder;
	public String getServerLogFolder() {
		return serverLogFolder;
	}
	public void setServerLogFolder(String serverLogFolder) {
		this.serverLogFolder = serverLogFolder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHostNameOrIp() {
		return hostNameOrIp;
	}
	public void setHostNameOrIp(String hostNameOrIp) {
		this.hostNameOrIp = hostNameOrIp;
	}
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPromptPassword() {
		return promptPassword;
	}
	public void setPromptPassword(boolean promptPassword) {
		this.promptPassword = promptPassword;
	}
	public boolean isPromptUserName() {
		return promptUserName;
	}
	public void setPromptUserName(boolean promptUserName) {
		this.promptUserName = promptUserName;
	}
	public List<LogLogger> getLoggers() {
		return loggers;
	}
	public void setLoggers(List<LogLogger> loggers) {
		this.loggers = loggers;
	}

	public boolean equals(LogServer logServer){
        if(StringUtils.equalsIgnoreCase(getName(),logServer.getName())
                &&StringUtils.equalsIgnoreCase(getHostNameOrIp(),logServer.getHostNameOrIp())
				&&StringUtils.equalsIgnoreCase(getUserName(),logServer.getUserName()))
            return true;
        else
            return false;
    }
	@Override
	public String toString() {
		return "LogServer [name=" + name + ", hostNameOrIp=" + hostNameOrIp
				+ ", port=" + port + ", userName=" + userName + ", password="
				+ password + ", promptPassword=" + promptPassword
				+ ", promptUserName=" + promptUserName + ", loggers=" + loggers
				+ ", serverLogFolder=" + serverLogFolder + "]";
	}
}
