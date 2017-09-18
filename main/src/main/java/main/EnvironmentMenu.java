package main;

import org.apache.commons.lang3.StringUtils;

import common.config.LogApplicationConfig;
import common.config.LogEnvironment;
import menu.GoBackMenuItem;
import menu.IndexedMenu;
import menu.MenuItem;
import menu.MenuResult;

public class EnvironmentMenu extends IndexedMenu{
	LogApplicationConfig logApplication;
	public EnvironmentMenu(LogApplicationConfig logApplication) {
		super("Select Ennvironment");
		
		this.logApplication = logApplication;
		addEnvironment();
		// TODO Auto-generated constructor stub
	}
	
	private void addEnvironment(){
		for(LogEnvironment environment:logApplication.getEnvironments()){
			MenuItem menuItem = new MenuItem(environment.getName(), environment.getName());
			addMenuItem(menuItem);
		}
		addMenuItem(new GoBackMenuItem()); 
	}
	private LogEnvironment findLogEnvironment(String environmentName){
		for(LogEnvironment environment:logApplication.getEnvironments()){
			if(StringUtils.equalsAnyIgnoreCase(environmentName, environment.getName())){
				return environment;
						
			}
		}
		return null;
	}
	public MenuResult displayMenu(){
		MenuResult result = super.displayMenu();
		if(!result.isGoBack()){
			LogEnvironment environment = findLogEnvironment(result.getKey());
			LogServerMenu logServerMenu = new LogServerMenu(environment);
			MenuResult logServerMenuResult = logServerMenu.displayMenu();
			if(logServerMenuResult.isGoBack())
				displayMenu();
		}
		return result;
	}

}
