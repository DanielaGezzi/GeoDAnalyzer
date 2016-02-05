package crawler.facebook;

import facade.FacadeGeoData;
import facade.impl.FacadeGeoDataImpl;
import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import model.GeoData;
import model.Location;

public class CrawlerF {
	
			public static void startSearch(String queryParam) throws Exception {
				/*auth in order to access facebook dev*/
				Login login = new Login(); 
				ConfigurationBuilder cb = login.start();
				
				FacebookFactory ff = new FacebookFactory(cb.build());
				Facebook facebook = ff.getInstance();
								
				Reading reading = new Reading();
				reading.fields("event,name,venue,description");
								
				try {		
						ResponseList<Event> results = facebook.searchEvents(queryParam, reading);
						if (results.isEmpty()) {
							System.out.println("results is empty");
						}	
						manageSearchResult(results);
					}
				
				catch(FacebookException e) {
					
							System.out.println("Facebook Exception" + e.getErrorCode());
							System.out.println(e.getErrorMessage());
							Thread.sleep((30)*1000);
							
				}
				
			}

			public static void manageSearchResult(ResponseList<Event> results) throws Exception {
				
				for (Event event : results) {
					
					if (event != null){
					manageSingleEvent(event);	
					}
				}
			}
						
			public static void manageSingleEvent(Event event){			
							
				GeoData geoData = new GeoData();
				FacadeGeoData fgd = new FacadeGeoDataImpl();
					            	           	            
				try {
					if(event.getVenue()!= null)						
					if(event.getVenue().getLatitude() != null){
						
						geoData.setId(event.getId());
						geoData.setPlatform("Facebook");
						geoData.setTitle(event.getName());
						geoData.setBody(event.getDescription());
						geoData.setAuthor("");
						geoData.setDate(event.getStartTime());
						
						double[] coordinates = {event.getVenue().getLongitude(),event.getVenue().getLatitude()};
						Location location = new Location("Point",coordinates);
						geoData.setLocation(location);
											
						fgd.saveGeoData(geoData);
					}
											
				}catch (Exception e){
					
					e.printStackTrace();
				
				}
			}
		public static void main(String[] args){
			try {
				startSearch("Roma");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

