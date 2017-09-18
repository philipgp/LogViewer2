package destination.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import common.LogWithMetadata;
import destination.LogDestination;

public class MongoDbDestination implements LogDestination{
	private String mongoServer,collectionName,dbName;
	private Integer mongoPort;
	private MongoClient mongoClient;
	MongoDatabase logVw ;
	public MongoDbDestination(String mongoServer, String collectionName,String dbName,
			Integer mongoPort) {
		super();
		this.mongoServer = mongoServer;
		this.dbName = dbName;
		this.collectionName = collectionName;
		this.mongoPort = mongoPort;
		mongoClient = new MongoClient(mongoServer,mongoPort);
		logVw = mongoClient.getDatabase(dbName); 
		MongoCollection<Document> collection = logVw.getCollection(collectionName);
	}
	@Override
	public void save(LogWithMetadata logWithMetadata) {
		// TODO Auto-generated method stub
		
	}
}
