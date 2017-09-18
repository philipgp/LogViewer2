package org.logviewer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.config.LogConfig;

import java.io.File;
import java.io.InputStream;

public class LogConfigReader {
	public LogConfig getConfig() throws Exception{
		//BufferedReader bir  = new BufferedReader(new FileReader("config.txt"));
		File file = new File("config.txt");
		/*StringBuilder sb = new StringBuilder();
		while(bir.ready()){
			sb.append(bir.readLine());
		} */
		InputStream inputStream = 
			      getClass().getClassLoader().getResourceAsStream("config.txt");
		ObjectMapper objectMapper = new ObjectMapper();
		LogConfig logConfig = objectMapper.readValue(inputStream, LogConfig.class);
		return logConfig;
	}
}
