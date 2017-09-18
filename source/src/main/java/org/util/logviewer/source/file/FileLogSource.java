package org.util.logviewer.source.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.util.logviewer.source.LogSource;

public class FileLogSource implements LogSource{

	File file;
	BufferedReader bir ;
	public FileLogSource(File file) throws Exception{
		init(file);
		
	}
	public FileLogSource(InputStream is){
		 bir = new BufferedReader(new InputStreamReader(is));
	}
	private void init(File file) throws Exception{
		this.file = file;
		FileReader fileReader = new FileReader(file);
		
		bir = new BufferedReader(fileReader);
	}
	
	public FileLogSource(String fileName) throws Exception{
		init(new File(fileName));
	}
	@Override
	public String readLog() throws Exception {
		return bir.readLine();
	}
	@Override
	public boolean hasMoreData() {
		// TODO Auto-generated method stub
		try {
			return bir.ready();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
