package menu;

import org.apache.commons.lang3.StringUtils;

public class MenuResult extends MenuItem{

	public MenuResult(MenuItem menuItem) {
		super(menuItem);
		// TODO Auto-generated constructor stub
	}
	
	public MenuResult(String key, String displayValue) {
		super(key, displayValue);
	}

	public boolean isGoBack(){
		if(StringUtils.equalsIgnoreCase(getKey(), new GoBackMenuItem().getKey())){
			return true;
		}else
			return false;
	}
	
}
