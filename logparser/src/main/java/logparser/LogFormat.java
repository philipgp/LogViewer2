package logparser;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class LogFormat {
	private String logFormat;

	public LogFormat(String logFormat) {
		super();
		this.logFormat = logFormat;
	} 
	public List<String> split(){
		List<String> strings = new ArrayList<>();
		if(StringUtils.contains(logFormat, "%d{")){
			int startIndex = logFormat.indexOf("%d{");;
			int endIndex = logFormat.indexOf("}",startIndex);
			String stripped = logFormat.substring(startIndex,endIndex+1);
			strings.add(stripped.trim());
			logFormat = logFormat.substring(endIndex+2);
		}
		String[] splitStrings = logFormat.split(" ");
		for(String split:splitStrings){
			strings.add(split.trim());
		} 
		return strings;
	}
}
