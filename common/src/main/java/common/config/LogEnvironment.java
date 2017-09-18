package common.config;

import java.util.ArrayList;
import java.util.List;

public class LogEnvironment {
	private List<LogServer> servers;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addServer(LogServer logServer){
		if(servers== null)
			servers = new ArrayList<>();
		servers.add(logServer);
	}

	public List<LogServer> getServers() {
		return servers;
	}

	public void setServers(List<LogServer> servers) {
		this.servers = servers;
	}

	@Override
	public String toString() {
		return "LogEnvironment [servers=" + servers + ", name=" + name + "]";
	}
}
