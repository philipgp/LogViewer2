package main;

import menu.MenuResult;
import menu.ValueMenu;

public class ServerCredentialMenu extends ValueMenu{

	public ServerCredentialMenu(String serverName) {
		super("Credentials for "+serverName, "password");
	}
	public MenuResult displayMenu() {
		MenuResult result = super.displayMenu();
		return result;
	}
}
