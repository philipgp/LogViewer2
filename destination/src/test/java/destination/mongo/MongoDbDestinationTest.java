package destination.mongo;

import static org.junit.Assert.*;

import org.junit.Test;

import common.LogWithMetadata;

public class MongoDbDestinationTest {

	@Test
	public void testSave() {
		MongoDbDestination mongoDbDestination = new MongoDbDestination("1qdnsp07", "logVw","logVw" ,30000);
		LogWithMetadata logWithMetadata  =  new LogWithMetadata();
		mongoDbDestination.save(logWithMetadata);
	}

}
