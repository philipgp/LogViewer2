package menu;

public class IndexedMenu extends AbstractMenu{


	public IndexedMenu(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MenuResult displayMenu() {
		if(menuItems.size() <1)
			throw new RuntimeException("Number of menu items less than 2");
		if(menuItems.size() == 1){
			return new MenuResult(menuItems.get(0));
		}
			
		printTitle();
		printMenuItems();
		printChoseOptions();
		String consoleEntry = readFromConsole();
		Integer index ;
		try{
			index = Integer.valueOf(consoleEntry);
			if(index>menuItems.size()+1){
				throw new Exception("Invalid Number");
			}
			MenuItem menuItem = menuItems.get(index-1);
			MenuResult menuResult = new MenuResult(menuItem);
			return menuResult;
		}catch(Exception e){
			System.out.println("Invalid selection"); 
			return displayMenu();
		}

	}
	private void printChoseOptions(){
		System.out.println("Choose from above menu items (1-"+menuItems.size()+"):");
	}
	private void printMenuItems(){
		int index =1;
		for(MenuItem menuItem:menuItems){
			System.out.println(index+")"+menuItem.getDisplayValue());
			index++;
		}
	}




}
