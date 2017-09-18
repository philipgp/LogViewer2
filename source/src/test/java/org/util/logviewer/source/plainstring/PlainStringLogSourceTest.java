package org.util.logviewer.source.plainstring;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlainStringLogSourceTest {
	public static String newline = System.getProperty("line.separator");
	@Test
	public void test() throws Exception {
		PlainStringLogSource ps   = new PlainStringLogSource("abcd"+newline+"efgh");
		String text = ps.readLog();
		assertEquals("abcd", text);
	}
	
	@Test
	public void test2() throws Exception {
		PlainStringLogSource ps   = new PlainStringLogSource("abcd"+newline+"efgh");
		String text = ps.readLog();
		text = ps.readLog();
		assertEquals("efgh", text);
	}
	
	@Test
	public void test3() throws Exception {
		PlainStringLogSource ps   = new PlainStringLogSource("abcd"+newline+"efgh");
		String text = ps.readLog();
		text = ps.readLog();
		text = ps.readLog();
		assertEquals("", text);
	}

}
