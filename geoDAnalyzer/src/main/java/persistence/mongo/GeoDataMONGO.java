package persistence.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

import model.GeoData.GeoData;
import model.GeoData.Location;
import persistence.GeoDataRepository;

public class GeoDataMONGO implements GeoDataRepository {
	private static MongoClient mongoClient;
	private static MongoCollection <BasicDBObject> collectionGeoData;
	
	public GeoDataMONGO(){
		
		super();
		mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("siiproject");
        collectionGeoData = db.getCollection("GeoData", BasicDBObject.class);
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); 
	}
	
	/*save a new GeoData Object into Mongo Database*/
	public void saveGeoData(GeoData geoData){
		
		try {
			
		Gson gson = new Gson();
		BasicDBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(geoData));
        collectionGeoData.insertOne(dbObject);
        
		} catch (MongoWriteException m) {
			
			System.out.println("Duplicate found");
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		}
			
		}
	
	/*find GeoData near to a specified Point Location (1000m)*/
	public List<GeoData> findProximity (Location location){
		
		BasicDBList myLocation = new BasicDBList();
		myLocation.put(0, location.getCoordinates()[0]);
		myLocation.put(1, location.getCoordinates()[1]);
		FindIterable<BasicDBObject> list = collectionGeoData.find(
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
	
	/*find GeoDatas inside a specified MultiPolygon Administrative Area*/
	public List<GeoData> findWithinMultiPolygon (double[][][][] multiPolygonArea){
		
		FindIterable<BasicDBObject> list = collectionGeoData.find(
		            new BasicDBObject("location",
		                new BasicDBObject("$geoWithin",
		                        new BasicDBObject("$geometry",
		                        		 new BasicDBObject("type", "MultiPolygon")
		                                    .append("coordinates", multiPolygonArea))
		                             )
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

