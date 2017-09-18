package logparser;

import static org.junit.Assert.*;
import h2.H2Destination;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.util.logviewer.source.LogSource;
import org.util.logviewer.source.plainstring.PlainStringLogSource;

import common.LogMetaData;
import common.LogWithMetadata;
import common.config.LogSourceConfig;
import destination.LogDestination;

public class LogParserImplTest {

	@Test
	public void testParseDate() throws ParseException {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		Date parsedDate = logParserImpl.parseDate("2017-05-21_18:30:00.008", "%d{yyyy-MM-dd_HH:mm:ss.SSS}");
		assertNotNull(parsedDate);
		
	}
	
	@Test
	public void testParseDate2() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		String actualLog="2017-05-21 18:30:00.008 thread1 INFO logger1 - this is the message";
		LogFullText logFullText = new LogFullText(actualLog);
		String lineFormat="%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n";
		LogWithMetadata logWithMetaData = new LogWithMetadata();
		logParserImpl.splitString(logFullText, lineFormat, logWithMetaData);
		assertEquals("INFO", logWithMetaData.getLevel());
		assertEquals("thread1", logWithMetaData.getThreadName());
		assertEquals("this is the message", logWithMetaData.getLogMsg());
		assertNotNull(logWithMetaData.getDate());
		Date date = logWithMetaData.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		assertEquals(21, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(4, cal.get(Calendar.MONTH));
		assertEquals(2017, cal.get(Calendar.YEAR));
		/*assertEquals("this is the message", logWithMetaData.getLogMsg());*/
		
	}
	
	
	@Test
	public void testParseDate3() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		String actualLog="2017-05-21_18:30:00.008 thread1 INFO logger1 - this is the message";
		LogFullText logFullText = new LogFullText(actualLog);
		String lineFormat="%d{yyyy-MM-dd_HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n";
		LogWithMetadata logWithMetaData = new LogWithMetadata();
		logParserImpl.splitString(logFullText, lineFormat, logWithMetaData);
		assertEquals("INFO", logWithMetaData.getLevel());
		assertEquals("thread1", logWithMetaData.getThreadName());
		assertEquals("this is the message", logWithMetaData.getLogMsg());
		assertNotNull(logWithMetaData.getDate());
		Date date = logWithMetaData.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		assertEquals(21, cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(4, cal.get(Calendar.MONTH));
		assertEquals(2017, cal.get(Calendar.YEAR));
		
	}
	@Test
	public void testParseDate4() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData("this doesn't have metadata", logSourceConfig );
		assertTrue(metadata.isEmpty());
	}
	
	@Test
	public void testParseDate5() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData("", logSourceConfig );
		assertTrue(metadata.isEmpty());
	}
	@Test
	public void testParseDate6() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData(null, logSourceConfig );
		assertTrue(metadata.isEmpty());
	}
	
	@Test
	public void testParseDate7() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData("metakey1:metavalue1", logSourceConfig );
		assertFalse(metadata.isEmpty());
		assertEquals("metavalue1",metadata.getValue("metakey1"));
	}
	@Test
	public void testParseDate8() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData("metakey1:metavalue1,metakey2:metavalue2", logSourceConfig );
		assertFalse(metadata.isEmpty());
		assertEquals("metavalue1",metadata.getValue("metakey1"));
		assertEquals("metavalue2",metadata.getValue("metakey2"));
	}
	
	@Test
	public void testParseDate9() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		LogMetaData metadata = logParserImpl.buildMetaData("metakey1:metavalue1 value of,metakey2:metavalue2", logSourceConfig );
		assertFalse(metadata.isEmpty());
		assertEquals("metavalue1 value of",metadata.getValue("metakey1"));
		assertEquals("metavalue2",metadata.getValue("metakey2"));
	}
	
	@Test
	public void testParseDate10() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		logSourceConfig.setKeyValueSeparator("::");
		LogMetaData metadata = logParserImpl.buildMetaData("metakey1::metavalue1 value of,metakey2::metavalue2", logSourceConfig );
		assertFalse(metadata.isEmpty());
		assertEquals("metavalue1 value of",metadata.getValue("metakey1"));
		assertEquals("metavalue2",metadata.getValue("metakey2"));
	}
	@Test
	public void testParseDate11() throws Exception {
		LogParserImpl logParserImpl = new LogParserImpl(null);
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		logSourceConfig.setKeyValueSeparator("::");
		logSourceConfig.setMetaDataSeparator("&&");
		LogMetaData metadata = logParserImpl.buildMetaData("metakey1::metavalue1 value of && metakey2::metavalue2", logSourceConfig );
		assertFalse(metadata.isEmpty());
		assertEquals("metavalue1 value of",metadata.getValue("metakey1"));
		assertEquals("metavalue2",metadata.getValue("metakey2"));
	}
	
	@Test
	public void testParse1() throws Exception {
		LogParser logParser = new LogParserImpl(null); 
		LogSource logSource = new PlainStringLogSource("2017-05-21_18:30:00.008 thread1 INFO logger1 - this is the message");
		LogDestination h2LogDestination = new H2Destination("test222");
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		logSourceConfig.setLineFormat("%d{yyyy-MM-dd_HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n");
		logParser.parse(logSource, h2LogDestination, logSourceConfig);
		
	}
	
	@Test
	public void testParse2() throws Exception {
		LogParser logParser = new LogParserImpl(null); 
		LogSource logSource = new PlainStringLogSource("2017-05-21_18:30:00.008 thread1 INFO logger1 - ffpNumber:ffp2");
		LogDestination h2LogDestination = new H2Destination("test222");
		LogSourceConfig logSourceConfig = new LogSourceConfig();
		logSourceConfig.setLineFormat("%d{yyyy-MM-dd_HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n");
		logParser.parse(logSource, h2LogDestination, logSourceConfig);
		
	}


}
