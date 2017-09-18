package h2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import common.LogMetaData;
import common.LogWithMetadata;
import destination.LogDestination;

public class H2Destination implements LogDestination{
	 Connection conn ;
	 
	 private final String LOG_META_DATA_INSERT = "INSERT INTO LOG_METADATA(LOG_DATE,FULL_TEXT,LOG_MSG,THREAD_NAME,LEVEL,TRANSACTION_ID) VALUES(?,?,?,?,?,?)";
	 PreparedStatement preparedStatement1 = null;
	 
	 private final String META_DATA_INSERT = "INSERT INTO METADATA(KEY,VALUE,LOG_METADATA_ID) VALUES(?,?,?)";
	 PreparedStatement preparedStatement2 = null;
	 
	public H2Destination(String dbName) throws Exception{
		Class.forName("org.h2.Driver");
         conn = DriverManager.getConnection("jdbc:h2:~/"+dbName, "sa", "");
         preparedStatement1 = conn.prepareStatement(LOG_META_DATA_INSERT, Statement.RETURN_GENERATED_KEYS);
         preparedStatement2 = conn.prepareStatement(META_DATA_INSERT, Statement.RETURN_GENERATED_KEYS); 
	}
	@Override
	public void save(LogWithMetadata logWithMetadata) throws Exception {
		Long insertId = insertLogMetaData(logWithMetadata);
		insertMetaData(logWithMetadata.getLogMetaData(), insertId);
	}
	private void insertMetaData(LogMetaData logWithMetadata,Long originalId) throws Exception{
		if(logWithMetadata!=null){
			Set<Entry<String, String>> entrySet = logWithMetadata.getEntrySet();
			if(entrySet!=null ){
				Iterator<Entry<String, String>> iterator = entrySet.iterator();
				while(iterator.hasNext()){
					Entry<String, String> it = iterator.next();
					preparedStatement2.setString(1, it.getKey());
					preparedStatement2.setString(2, it.getValue());
					preparedStatement2.setLong(3, originalId);
					preparedStatement2.executeUpdate();
				}
			}
		}
	}
	private Long insertLogMetaData(LogWithMetadata logWithMetadata) throws Exception{
		Date sqlDate = new Date(logWithMetadata.getDate().getTime());
		preparedStatement1.setDate(1, sqlDate);
		preparedStatement1.setString(2, logWithMetadata.getFullText());
		preparedStatement1.setString(3, logWithMetadata.getLogMsg());
		preparedStatement1.setString(4, logWithMetadata.getThreadName());
		preparedStatement1.setString(5, logWithMetadata.getLevel());
		preparedStatement1.setLong(6, logWithMetadata.getTransactionId());
		preparedStatement1.executeUpdate();
		 ResultSet generatedKeys = preparedStatement1.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            long id = generatedKeys.getLong(1);
	            return id;
	        } else {
	           return null;
	        }
	}
	
	public static void main(String[] a) throws Exception{
		H2Destination h2Destination = new H2Destination("test222");
		LogWithMetadata logWithMetadata = new LogWithMetadata();
		logWithMetadata.setDate(new java.util.Date());
		logWithMetadata.setFullText("full text");
		logWithMetadata.setLevel("info");
		logWithMetadata.setLogMsg("logmsg");
		logWithMetadata.setThreadName("thread1");
		logWithMetadata.setTransactionId(111L);
		LogMetaData logMetaData = new LogMetaData();
		logMetaData.add("ffpNumber", "ffp1");
		logWithMetadata.setLogMetaData(logMetaData);
		h2Destination.save(logWithMetadata); 
       /* //Statement stmt = conn.createStatement(); 
        PreparedStatement preparedStatement = conn.prepareStatement("insert into LOG_METADATA(TEXT) values('asdfasd')", Statement.RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            long id = generatedKeys.getLong(1);
            System.out.println(id);
        } else {
            // Throw exception?
        }
        conn.close();*/
	}

}
