package model.support;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


import static java.util.Arrays.asList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


import org.bson.Document;
 
 
public class CrawlerTEST {
 
    private static MongoClient mongoClient;
   
 
 
    public static void main(String args[]) throws ParseException {

		mongoClient = new MongoClient("localhost", 27017);
	    MongoDatabase db = mongoClient.getDatabase("prova");
	    db.createCollection("ristoranti");
	               
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            db.getCollection("restaurants").insertOne(
            		new Document("address",
            				new Document()
            				.append("street", "2 Avenue")
            				.append("zipcode", "10075")
            				.append("buuilding", "1480")
            				.append("coord", asList(-73.9557413, 40.770266)))
            		.append("borough", "Manatthan")
            		.append("cuisine", "italian")
            		.append("grades", asList(
            				new Document()
	            				.append("date", format.parse("2014-10-01T00:00:00Z"))
	            				.append("grade", "A")
	            				.append("score", 11),
            				new Document()
            					.append("date", format.parse("2014-01-16T00:00:00Z"))
            					.append("grade", "B")
            					.append("score", 17)))
            		.append("name", "Vella")
            		.append("restaurant_id", 41704620));
            
           
 
    }
}