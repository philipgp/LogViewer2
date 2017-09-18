package common.config;

public class LogLogger {
	private String logFileName,archiveFolder,name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String logFormat;
	public String getLogFileName() {
		return logFileName;
	}
	@Override
	public String toString() {
		return "LogLogger [logFileName=" + logFileName + ", archiveFolder="
				+ archiveFolder + ", name=" + name + ", logFormat=" + logFormat
				+ "]";
	}
	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}
	public String getArchiveFolder() {
		return archiveFolder;
	}
	public void setArchiveFolder(String archiveFolder) {
		this.archiveFolder = archiveFolder;
	}
	public String getLogFormat() {
		return logFormat;
	}
	public void setLogFormat(String logFormat) {
		this.logFormat = logFormat;
	}
}
