package common;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LogMetaData{
	private HashMap<String,String> map = new HashMap<String, String>();
	public void add(String key,String value){
		map.put(key, value);
		
	}
	public String getValue(String key){
		return map.get(key);
	}
	public Set<Entry<String, String>> getEntrySet(){
		return map.entrySet();
	}
	public boolean isEmpty(){
		return map.isEmpty();
	}
}
