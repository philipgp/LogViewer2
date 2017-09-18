package common;

import java.util.Date;

public class LogWithMetadata {
	private String fullText,logMsg,threadName,level;
	private Date date;
	private Long transactionId=0L;
	private LogMetaData logMetaData;
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public String getLogMsg() {
		return logMsg;
	}
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public LogMetaData getLogMetaData() {
		return logMetaData;
	}
	public void setLogMetaData(LogMetaData logMetaData) {
		this.logMetaData = logMetaData;
	}
	@Override
	public String toString() {
		return "LogWithMetadata [fullText=" + fullText + ", logMsg=" + logMsg
				+ ", threadName=" + threadName + ", level=" + level + ", date="
				+ date + ", transactionId=" + transactionId + ", logMetaData="
				+ logMetaData + "]";
	}
}
