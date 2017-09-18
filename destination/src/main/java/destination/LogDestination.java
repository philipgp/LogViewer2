package destination;

import common.LogWithMetadata;

public interface LogDestination {
	public void save(LogWithMetadata logWithMetadata) throws Exception;
}
