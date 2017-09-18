package common.config;

import java.util.ArrayList;
import java.util.List;

public class LogApplicationConfig {
	private String applicationName;
	private List<String> metadataKeys;
	private List<String> loggerNames;



	private List<LogEnvironment> environments;
	public String getApplicationName() {
		return applicationName;
	}
	public void addEnvironment(LogEnvironment logEnvironment){
		if(environments == null)
			environments = new ArrayList<>();
		environments.add(logEnvironment);
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public List<String> getMetadataKeys() {
		return metadataKeys;
	}
	public void setMetadataKeys(List<String> metadataKeys) {
		this.metadataKeys = metadataKeys;
	}
	public List<LogEnvironment> getEnvironments() {
		return environments;
	}
	public void setEnvironments(List<LogEnvironment> environments) {
		this.environments = environments;
	}
	public List<String> getLoggerNames() {
		return loggerNames;
	}

	public void setLoggerNames(List<String> loggerNames) {
		this.loggerNames = loggerNames;
	}
	@Override
	public String toString() {
		return "LogApplicationConfig [applicationName=" + applicationName
				+ ", metadataKeys=" + metadataKeys + ", environments="
				+ environments + "]";
	}
}
