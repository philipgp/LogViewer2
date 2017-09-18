package org.util.logviewer.source;

public interface LogSource {
	public String readLog() throws Exception;
	public boolean hasMoreData();
}
