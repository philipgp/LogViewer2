package logparser;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogFullTextTest {

	@Test
	public void test() {
		LogFullText logFullText = new LogFullText("thread1");
		String thread = logFullText.getString("[%thread]");
		assertEquals("thread1", thread);
	}
	
	@Test
	public void test2() {
		LogFullText logFullText = new LogFullText("thread1 logger1");
		String thread = logFullText.getString("[%thread]");
		assertEquals("thread1", thread);
	}
	
	@Test
	public void test3() {
		LogFullText logFullText = new LogFullText("thread1 logger1");
		String thread = logFullText.getString("[%thread]");
		assertEquals("thread1", thread);
		
		String logger = logFullText.getString("[%logger]");
		assertEquals("logger1", logger);
	}
	
	@Test
	public void test4() {
		LogFullText logFullText = new LogFullText("thread1 logger1 msgsg of all king");
		String thread = logFullText.getString("[%thread]");
		assertEquals("thread1", thread);
		
		String logger = logFullText.getString("[%logger]");
		assertEquals("logger1", logger);
		
		String msg = logFullText.getString("%msg%n");
		assertEquals("msgsg of all king", msg);
	}

}
