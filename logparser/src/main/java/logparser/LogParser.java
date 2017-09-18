package logparser;

import org.util.logviewer.source.LogSource;

import common.config.LogSourceConfig;

import destination.LogDestination;

public interface LogParser {
	public void parse(LogSource source,LogDestination destination,LogSourceConfig logSourceConfig) throws Exception;
}
