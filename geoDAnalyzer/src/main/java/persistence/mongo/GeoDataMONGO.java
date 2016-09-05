package persistence.mongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoWriteException;
import com.mongodb.client.AggregateIterable;
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
	private static MongoCollection <BasicDBObject> collection;

	
	public GeoDataMONGO(){
		
		super();
		mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("siiproject");
        collectionGeoData = db.getCollection("GeoData", BasicDBObject.class);
        collection = db.getCollection("GeoData_copy", BasicDBObject.class);
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
	
	/*public List<GeoData> findProximity (Location location){
		
		BasicDBList myLocation = new BasicDBList();
		myLocation.put(0, location.getCoordinates()[0]);
		myLocation.put(1, location.getCoordinates()[1]);        
        
		FindIterable<BasicDBObject> list = collectionGeoData
				.find(
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
		
		
	} */
	
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
	
	/*find GeoData near to a specified Point Location (1000m)*/
	public List<JsonObject> findProximity (Location location){
				
		BasicDBList myLocation = new BasicDBList();
		myLocation.put(0, location.getCoordinates()[0]);
		myLocation.put(1, location.getCoordinates()[1]);  
		
		DBObject geoNearFields = new BasicDBObject();
        geoNearFields.put("near", myLocation);
        geoNearFields.put("distanceField", "distance");
        geoNearFields.put("maxDistance", 1000);
        geoNearFields.put("spherical", true);
        DBObject geoNear = new BasicDBObject("$geoNear", geoNearFields);
				
		DBObject lookupFields = new BasicDBObject("from", "itaadminarea");
        lookupFields.put("localField", "_idAdminArea");
        lookupFields.put("foreignField", "_id");
        lookupFields.put("as", "itaadminarea");      
        DBObject lookup = new BasicDBObject("$lookup", lookupFields);
        
        DBObject projectFields = new BasicDBObject("id", 1);
        projectFields.put("platform", 1);
        projectFields.put("title", 1);
        projectFields.put("author", 1);
        projectFields.put("body", 1);
        projectFields.put("date", 1);
        projectFields.put("location", 1);
        projectFields.put("_idAdminArea", 1);
        projectFields.put("areaNation", "$itaadminarea.properties.NAME_0");
        projectFields.put("areaRegion", "$itaadminarea.properties.NAME_1");       
        projectFields.put("areaDistrict", "$itaadminarea.properties.NAME_2");       
        DBObject project = new BasicDBObject("$project", projectFields);
        
        @SuppressWarnings("unchecked")
		List<? extends Bson> pipeline = (List<? extends Bson>) Arrays.asList(geoNear, lookup, project);

        AggregateIterable<BasicDBObject> output = collection.aggregate(pipeline);

		JsonParser jsonParser = new JsonParser();
        List<JsonObject> result = new ArrayList<JsonObject>();
        for (BasicDBObject o : output) {
        	JsonObject jobj = jsonParser.parse(o.toString()).getAsJsonObject();
            result.add(jobj);
            System.out.println(jobj);
        }
        return result;
	}
		
}

