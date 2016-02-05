package crawler.instagram;

import java.util.List;

import org.jinstagram.Instagram;
import org.jinstagram.entity.tags.TagMediaFeed;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;

import facade.FacadeGeoData;
import facade.impl.FacadeGeoDataImpl;

import model.GeoData;
import model.Location;


public class CrawlerI {
	
	public static void startSearch(String queryParam) throws Exception{
	
		/*InstagramService service = new InstagramAuthService()
				.apiKey("db37708863204bd6a4985e79e6f00084")
				.apiSecret("5ea0921249a94db89a31eb99c12a5ecc")
				.callback("http://localhost/geoDAnalyzer")
				.build();
		
		
		
		service.getAccessToken(arg0, arg1)
		Instagram instagram = service.getInstagram(accessToken);*/
		Instagram instagram = new Instagram("43e80f5cfdb44e45b05f46bf1387b578");

		try {
			System.out.println(instagram.searchMedia(48.858844, 2.294351));
			TagMediaFeed mediaFeed = instagram.getRecentMediaTags(queryParam);
			List<MediaFeedData> mediaFeeds = mediaFeed.getData();
			if (mediaFeeds.isEmpty()) {
				System.out.println("results is empty");
			}	
			manageSearchResult(mediaFeeds);
		} catch (InstagramException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void manageSearchResult(List<MediaFeedData> results) throws Exception {
		
		for (MediaFeedData data : results) {
			
			if (data != null){
			manageSingleEvent(data);	
			}
		}
	}
	
	public static void manageSingleEvent(MediaFeedData data){			
		
		GeoData geoData = new GeoData();
		FacadeGeoData fgd = new FacadeGeoDataImpl();
			            	           	            
		try {
			if(data.getLocation()!=null)						
			if((Double)data.getLocation().getLatitude() != null){
				
				geoData.setId(data.getId());
				geoData.setPlatform("Instagram");
				geoData.setTitle("");
				geoData.setBody(data.getImages().getLowResolution().getImageUrl());
				geoData.setAuthor(data.getUser().getUserName());
				geoData.setDate(null);
				
				double[] coordinates = {data.getLocation().getLongitude(),data.getLocation().getLatitude()};
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
			startSearch("Rome");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
