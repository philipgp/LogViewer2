package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractMenu implements Menu{
	protected String title;
	Scanner scanner = new Scanner(System.in);
	public AbstractMenu(String title) {
		super();
		this.title = title;
	}
	protected List<MenuItem> menuItems = new ArrayList<>();
	public void addMenuItem(MenuItem menuItem){
		menuItems.add(menuItem);
	}
	public String readFromConsole(){
		String inputFromConsole = scanner.nextLine();
		return inputFromConsole;
	}
	protected void printTitle(){
		System.out.println(title);
	}
}
