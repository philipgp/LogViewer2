package common.config;

public class LogSourceConfig {
	private String lineFormat;
	private String metaDataSeparator=",";
	private String keyValueSeparator=":";
	public String getMetaDataSeparator() {
		return metaDataSeparator;
	}

	public void setMetaDataSeparator(String metaDataSeparator) {
		this.metaDataSeparator = metaDataSeparator;
	}

	public String getKeyValueSeparator() {
		return keyValueSeparator;
	}

	public void setKeyValueSeparator(String keyValueSeparator) {
		this.keyValueSeparator = keyValueSeparator;
	}

	@Override
	public String toString() {
		return "LogSourceConfig [lineFormat=" + lineFormat
				+ ", metaDataSeparator=" + metaDataSeparator
				+ ", keyValueSeparator=" + keyValueSeparator + "]";
	}

	public String getLineFormat() {
		return lineFormat;
	}

	public void setLineFormat(String lineFormat) {
		this.lineFormat = lineFormat;
	}
}
