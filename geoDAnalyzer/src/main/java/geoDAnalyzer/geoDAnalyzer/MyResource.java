package geoDAnalyzer.geoDAnalyzer;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import facade.FacadeGeoData;
import facade.impl.FacadeGeoDataImpl;
import model.Location;
import model.GeoData;

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
	public List<GeoData> getResults(@PathParam("lat") double latitude,
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
    
    /*@GET
	@Produces(MediaType.TEXT_HTML)
	public String prova(){
		return "Hello World!";
	}*/
}
