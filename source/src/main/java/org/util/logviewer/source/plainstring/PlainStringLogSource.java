package org.util.logviewer.source.plainstring;

import org.apache.commons.lang3.StringUtils;
import org.util.logviewer.source.LogSource;

public class PlainStringLogSource implements LogSource{
	String data ;
	int lineNumber = 0;
	String[] dataSplit = null;
	public static String newline = System.getProperty("line.separator");
	public PlainStringLogSource(String data) {
		super();
		this.data = data;
		if(StringUtils.isNotEmpty(data))
			dataSplit = data.split(newline) ;
	}

	@Override
	public String readLog() throws Exception {
		if(hasMoreData()){
			return dataSplit[lineNumber++];
		}else
			return "";
		
		
	}

	@Override
	public boolean hasMoreData() {
		if(dataSplit!=null && dataSplit.length>lineNumber){
			return true;
		}else
			return false;
	}

}
