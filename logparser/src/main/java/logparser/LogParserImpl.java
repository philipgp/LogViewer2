package logparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.apache.commons.lang3.StringUtils;
import org.util.logviewer.source.LogSource;

import common.LogMetaData;
import common.LogWithMetadata;
import common.config.LogConfig;
import common.config.LogSourceConfig;
import destination.LogDestination;

public class LogParserImpl implements LogParser{

	private LogConfig config;
	
	public LogParserImpl(LogConfig config) {
		super();
		this.config = config;
	}

	@Override
	public void parse(LogSource source, LogDestination destination,LogSourceConfig logSourceConfig) throws Exception {
		while(source.hasMoreData()){
			String logText = source.readLog();
			LogFullText logFullText = new LogFullText(logText);
			LogWithMetadata logMetaData = parseMetaData(logFullText,logSourceConfig);
			destination.save(logMetaData);
		}
	}
	public LogWithMetadata parseMetaData(LogFullText logFullText,LogSourceConfig logSourceConfig) throws Exception{
		LogWithMetadata logWithMetadata = new LogWithMetadata();
		logWithMetadata.setFullText(logFullText.getFullText());
		splitString(logFullText, logSourceConfig.getLineFormat(), logWithMetadata);
		LogMetaData metadata = buildMetaData(logWithMetadata.getLogMsg(), logSourceConfig);
		logWithMetadata.setLogMetaData(metadata);
		return logWithMetadata;
		
	}
	public LogMetaData buildMetaData(String logMsg,LogSourceConfig logSourceConfig){
		LogMetaData logMetadata = new LogMetaData();
		if(StringUtils.isNotEmpty(logMsg)){
		String[] metadatas = logMsg.split(logSourceConfig.getMetaDataSeparator());
		if(metadatas!=null){
			for(String metadata:metadatas){
				String[] keyValueSeparator = metadata.split(logSourceConfig.getKeyValueSeparator());
				if(keyValueSeparator!=null && keyValueSeparator.length ==2){
					String key=keyValueSeparator[0].trim();
					String value=keyValueSeparator[1].trim();
					logMetadata.add(key, value);
				}
			}
		}
		}
		return logMetadata;
	}
	public void splitString(LogFullText logFullText,String lineFormat,LogWithMetadata logWithMetaData) throws Exception{
		LogFormat logFormat = new LogFormat(lineFormat);
		List<String> formatSplit = logFormat.split();
		for(String format:formatSplit){
		String currentText = logFullText.getString(format);
			if(StringUtils.startsWith(format, "%d{")){
				
				Date parsedDate = parseDate(currentText, format);
				logWithMetaData.setDate(parsedDate);
			}else if(StringUtils.equalsIgnoreCase(format, "[%thread]")){
				logWithMetaData.setThreadName(currentText);
			}else if(StringUtils.contains(format, "%msg%n")){
				logWithMetaData.setLogMsg(currentText);
			}else if(StringUtils.contains(format, "%-5level")){
				logWithMetaData.setLevel(currentText);
			}
			
			
		}
	}
	
	public Date parseDate(String logText,String format) throws ParseException{
		format = format.substring(3,format.length()-1);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date parsedDate = formatter.parse(logText);
		return parsedDate;
	}

}
