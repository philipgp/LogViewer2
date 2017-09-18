package menu;

public class MenuItem {
	private String key,displayValue;

	public String getKey() {
		return key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	public MenuItem(String key, String displayValue) {
		super();
		this.key = key;
		this.displayValue = displayValue;
	}
	
	public MenuItem(MenuItem menuItem){
		this.key = menuItem.getKey();
		this.displayValue = menuItem.getDisplayValue();
	}

	public String getDisplayValue() {
		return displayValue;
	}

	protected void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
