package main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import menu.GoBackMenuItem;
import menu.IndexedMenu;
import menu.MenuItem;
import menu.MenuResult;
import common.config.LogLogger;
import common.config.LogServer;

public class LoggerLogMenu extends IndexedMenu{
	LogServer server;
	public LoggerLogMenu(LogServer server) {
		super("Select Logs");
		this.server = server;
		addMenu();
		// TODO Auto-generated constructor stub
	}
	private void addMenu(){
		for(LogLogger log:server.getLoggers()){
			MenuItem menuItem = new MenuItem(log.getName(),log.getName());
			addMenuItem(menuItem);
		}
		
		addMenuItem(new MenuItem("all", "ALL"));
		addMenuItem(new GoBackMenuItem());
	}
	private List<LogLogger> find(String key){
		List<LogLogger> logServers = new ArrayList<LogLogger>();
		for(LogLogger logger:server.getLoggers()){
			if(StringUtils.equalsAnyIgnoreCase(key, "all")|| StringUtils.equalsAnyIgnoreCase(key, logger.getName())){
				logServers.add(logger);
			}
		}
		return logServers;
	}

	public List<LogLogger> getLoggers(){
		MenuResult result = super.displayMenu();
		return find(result.getKey());
	}
	/*public MenuResult displayMenu() {
		MenuResult result = super.displayMenu();
	}*/

}
