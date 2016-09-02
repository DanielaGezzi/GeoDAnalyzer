package geoDAnalyzer.geoDAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.flickr4java.flickr.FlickrException;
import com.google.gson.Gson;
import crawler.facebook.CrawlerF;
import crawler.flickr.CrawlerFl;
import crawler.twitter.CrawlerT;
import facade.FacadeAdministrativeArea;
import facade.FacadeGeoData;
import facade.impl.FacadeAdministrativeAreaImpl;
import facade.impl.FacadeGeoDataImpl;
import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.GeoData;
import model.GeoData.Location;
import twitter4j.TwitterException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    
    @GET
	@Path("/events/{lat}/{lon}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<GeoData> getResultsProximity(@PathParam("lat") double latitude,
									@PathParam("lon") double longitude){
		FacadeGeoData facadeGeoData = new FacadeGeoDataImpl();
		List<GeoData> results = new ArrayList<GeoData>();
		Location location = new Location();
		location.setType("Point");
		double[] coord = {longitude,latitude};
		location.setCoordinates(coord);
		try{
		results = facadeGeoData.getGeoDataProximity(location);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;}
    
    @GET
	@Path("/events/area/{lat}/{lon}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdministrativeArea> getResultsWhatArea(@PathParam("lat") double latitude,
									@PathParam("lon") double longitude){
		FacadeAdministrativeArea facadeAdminData = new FacadeAdministrativeAreaImpl();
		List<AdministrativeArea> results = new ArrayList<AdministrativeArea>();
		Location location = new Location();
		location.setType("Point");
		double[] coord = {longitude,latitude};
		location.setCoordinates(coord);
		try{
		results = facadeAdminData.getGeoDataAdminArea(location);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(results);
		return results
	;}
    
    @POST
    @Path("/admin/search/twitter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchOnTwitter(String queryParam){
    	Gson gson = new Gson();
    	@SuppressWarnings("unchecked")
		Map<String, String> map = gson.fromJson(queryParam, Map.class);    	
    	CrawlerT ct = new CrawlerT();
    	try {
			ct.startSearch(map.get("param"));
		}catch (TwitterException e){
			return Response.status(409).build();
			
		}catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		return Response.status(200).build();
    }
    
    @POST
    @Path("/admin/search/facebook")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchOnFacebook(String queryParam){
    	Gson gson = new Gson();
    	@SuppressWarnings("unchecked")
		Map<String, String> map = gson.fromJson(queryParam, Map.class);
    	CrawlerF cf = new CrawlerF();
    	try {
			cf.startSearch(map.get("param"));
		
		}catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		return Response.status(200).build();
    }
    
    @POST
    @Path("/admin/search/flickr")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response searchOnFlickr(String queryParam){
    	Gson gson = new Gson();
    	@SuppressWarnings("unchecked")
		Map<String, String> map = gson.fromJson(queryParam, Map.class);
    	CrawlerFl cfl = new CrawlerFl();
    	try {
			cfl.startSearch(map.get("param"));
		}catch (FlickrException e){
			System.out.println("flickr exception");
			return Response.status(400).build();
			
		}catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
		return Response.status(200).build();
    }
    
}
