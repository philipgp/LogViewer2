package main;

import common.config.LogConfig;

public class LogViewerMain {

	LogConfigReader logConfigReader = new LogConfigReader();
	ApplicationMenu applicationLogMenu;
	public void start() throws Exception{
		LogConfig config = logConfigReader.getConfig();
		applicationLogMenu = new ApplicationMenu(config);
		applicationLogMenu.displayMenu();
		System.out.println("So Long... and Thanks for all the fish");
	}
	public static void main(String[] args) throws Exception {
		LogViewerMain logViewerMain = new  LogViewerMain();
		logViewerMain.start();
	}
	

}
