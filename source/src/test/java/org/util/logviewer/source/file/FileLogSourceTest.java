package org.util.logviewer.source.file;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

public class FileLogSourceTest {

	@Test
	public void testReadLog() throws Exception {
		
		InputStream inputStream = 
			      getClass().getClassLoader().getResourceAsStream("log1.txt");
		FileLogSource logSource = new FileLogSource(inputStream);
		String firstLine = logSource.readLog();
		Assert.assertNotNull(firstLine);
	}

}
