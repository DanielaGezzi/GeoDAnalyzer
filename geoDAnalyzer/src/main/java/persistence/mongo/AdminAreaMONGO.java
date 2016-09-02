package persistence.mongo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.types.ObjectId;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.Location;
import persistence.AdminAreaRepository;

public class AdminAreaMONGO implements AdminAreaRepository {
	
	private static MongoClient mongoClient;
	private static MongoCollection <BasicDBObject> collectionAdminArea;
	
	public AdminAreaMONGO(){
		
		super();
		mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("siiproject");
        collectionAdminArea = db.getCollection("itaadminarea", BasicDBObject.class);
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); 
	}
	
	/*retrieve Administrative Area Object by ID*/
	public AdministrativeArea getAdminAreaById(ObjectId _id){
		AdministrativeArea adminArea = new AdministrativeArea();
		FindIterable<BasicDBObject> list = collectionAdminArea.find(
				new BasicDBObject("_id", _id));
		
		Gson gson = new Gson();
		for(BasicDBObject o : list){
			adminArea = gson.fromJson(o.toString(), AdministrativeArea.class);
			}
		return adminArea;
		
	};
	
	/*retrieve the list of MultiPolygon Administrative Area a Point GeoData Location belongs to*/
	public List<AdministrativeArea> findWhatMultiPolygon (Location location){
	
	BasicDBList myLocation = new BasicDBList();
	myLocation.put(0, location.getCoordinates()[0]);
	myLocation.put(1, location.getCoordinates()[1]);
	FindIterable<BasicDBObject> list = collectionAdminArea.find(
	            new BasicDBObject("geometry",
	                new BasicDBObject("$geoIntersects",
	                        new BasicDBObject("$geometry",
	                        		 new BasicDBObject("type", "Point")
	                                    .append("coordinates", myLocation))
	                             )
	                )
	            );
	
	List<AdministrativeArea> result = new ArrayList<AdministrativeArea>();
	Gson gson = new Gson();
	for(BasicDBObject o : list){
		AdministrativeArea adminArea = gson.fromJson(o.toString(), AdministrativeArea.class);
		result.add(adminArea);}
	return result;
	
	
}

}
