package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.config.LogConfig;

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
