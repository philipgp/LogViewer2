package main;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import common.config.LogApplicationConfig;
import common.config.LogConfig;
import common.config.LogEnvironment;
import menu.GoBackMenuItem;
import menu.IndexedMenu;
import menu.MenuItem;
import menu.MenuResult;

public class ApplicationMenu  extends IndexedMenu{
	LogConfig logConfig;
	public ApplicationMenu(LogConfig logConfig) {
		super("Select Application");
		this.logConfig = logConfig ;
		addApplications(logConfig);
	}
	
	private void addApplications(LogConfig logConfig){
		for(LogApplicationConfig application:logConfig.getApplications()){
			MenuItem menuItem = new MenuItem(application.getApplicationName(), application.getApplicationName());
			addMenuItem(menuItem);
		}
		addMenuItem(new GoBackMenuItem());
	}
	private LogApplicationConfig findApplication(String applicationName){
		for(LogApplicationConfig application:logConfig.getApplications()){
			if(StringUtils.equalsIgnoreCase(application.getApplicationName(), applicationName)){
				return application;
			}
		}
		return null;
	}
	public MenuResult displayMenu() {
		MenuResult result = super.displayMenu();
		if(!result.isGoBack()){
			LogApplicationConfig application = findApplication(result.getKey());
			EnvironmentMenu environment= new EnvironmentMenu(application);
			MenuResult environmentResult = environment.displayMenu();
			if(environmentResult.isGoBack())
				displayMenu();
		}
		return result;
	}
}
