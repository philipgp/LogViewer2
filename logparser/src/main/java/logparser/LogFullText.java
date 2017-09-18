package logparser;

import org.apache.commons.lang3.StringUtils;

public class LogFullText {
	public String getFullText() {
		return fullText;
	}

	
	private String fullText;
	private int currentIndex = 0;
	public LogFullText(String fullText) {
		super();
		this.fullText = fullText;
	};
	
	private int nextNonSpace(String fullText,int index){
		for(int i=index;i<fullText.length();i++){
			if(fullText.charAt(i)!=' '){
				return i;
			}
			
		}
		return fullText.length() -1;
	}
	public String getString(String format){
		if(StringUtils.equalsIgnoreCase(format, "%msg%n")){
			String returnString = fullText.substring(currentIndex);
			return returnString;
		}
		else if(StringUtils.startsWith(format, "%d{")){
			int length = format.length()-3;
			String returnString = fullText.substring(currentIndex, currentIndex+ length);
			currentIndex = nextNonSpace(fullText, currentIndex+ length) ;
			return returnString;
		}
		else{
			
			
			int index = fullText.indexOf(" ",currentIndex);
			String returnString = null;
			if(index!=-1){
				returnString = fullText.substring(currentIndex, index);
				currentIndex = nextNonSpace(fullText, index) ;
			}
			else{
				returnString = fullText.substring(currentIndex);
				currentIndex = fullText.length()-1;
			}
			
			return returnString;
		}
	}
	
	
	
}
