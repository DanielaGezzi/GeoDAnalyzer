package persistence.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import model.GeoData;
import model.Location;
import persistence.GeoDataRepository;

public class GeoDataMONGO implements GeoDataRepository {
	private static MongoClient mongoClient;
	private static MongoCollection <BasicDBObject> collection;
	
	public GeoDataMONGO(){
		
		super();
		mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("siiproject");
        collection = db.getCollection("GeoData", BasicDBObject.class);
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); 
	}
	
	/*save a new GeoData Object into Mongo Database*/
	public void saveGeoData(GeoData geoData){
		
		try {
			
		Gson gson = new Gson();
		BasicDBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(geoData));
        collection.insertOne(dbObject);
        
		} catch (MongoWriteException m) {
			
			System.out.println("Duplicate found");
			
			} catch (Exception e){
			
			e.printStackTrace();
			
			}
			
		}

	public List<GeoData> findProximity (Location location){
		
		BasicDBList myLocation = new BasicDBList();
		myLocation.put(0, location.getCoordinates()[0]);
		myLocation.put(1, location.getCoordinates()[1]);
		FindIterable<BasicDBObject> list = collection.find(
		            new BasicDBObject("location",
		                new BasicDBObject("$near",
		                        new BasicDBObject("$geometry",
		                        		 new BasicDBObject("type", "Point")
		                                    .append("coordinates", myLocation))
		                             .append("$maxDistance",  1000))
		                )
		            );
		
		List<GeoData> result = new ArrayList<GeoData>();
		Gson gson = new Gson();
		for(BasicDBObject o : list){
			GeoData geodata = gson.fromJson(o.toString(), GeoData.class);
			result.add(geodata);}
		return result;
		
		
	}  
		
}

