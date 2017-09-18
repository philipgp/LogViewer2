package menu;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexedMenuTest {

	@Test
	public void testDisplayMenu() {
		IndexedMenu indexedMenu = new IndexedMenu("Select Application");
		MenuItem menuItem = new MenuItem("nsp", "NSP Mobile Application");
		
		indexedMenu.addMenuItem(menuItem);
		
		MenuItem menuItem2 = new MenuItem("eis", "EIS");
		
		indexedMenu.addMenuItem(menuItem2);
		//MenuResult menuResult = indexedMenu.displayMenu(); 
		
		
	}
	
	@Test
	public void testDisplayMenu2() {
		IndexedMenu indexedMenu = new IndexedMenu("Select Application");
		MenuItem menuItem = new MenuItem("nsp", "NSP Mobile Application");
		
		indexedMenu.addMenuItem(menuItem);
		
		MenuItem menuItem2 = new MenuItem("eis", "EIS");
		
		indexedMenu.addMenuItem(menuItem2);
		indexedMenu.addMenuItem(new GoBackMenuItem());
		//MenuResult menuResult = indexedMenu.displayMenu(); 
		
		
	}

}
