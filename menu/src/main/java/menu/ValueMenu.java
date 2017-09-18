package menu;

public class ValueMenu extends AbstractMenu{
	String question;
	public ValueMenu(String title,String question) {
		super(title);
		this.question = question;
		// TODO Auto-generated constructor stub
	}

	@Override
	public MenuResult displayMenu() {
		printTitle();
		printChoseOptions();
		String readString = readFromConsole(); 
		MenuResult menuResult = new MenuResult(readString, readString);
		return menuResult;
	}
	
	private void printChoseOptions(){
		System.out.println("Enter "+question+":");
	}

}
