package crawler.flickr;

import java.util.Set;
import java.util.TreeSet;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;

import facade.FacadeGeoData;
import facade.impl.FacadeGeoDataImpl;
import model.GeoData;
import model.Location;

public class CrawlerFl {
	
	public void startSearch(String queryParam) throws Exception{
		
		Login login = new Login();
		
		Flickr flickr = login.start();
		
		SearchParameters searchParam = new SearchParameters();
		searchParam.setAccuracy(11);
		searchParam.setHasGeo(true);
		Set<String> extras = new TreeSet<String>();
		extras.add("geo");
		searchParam.setExtras(extras);
		String[] tags = {queryParam};
		searchParam.setTags(tags);
		

		try {
			PhotoList<Photo> list = flickr.getPhotosInterface().search(searchParam, 0, 0);
			if (list.isEmpty()) {
				System.out.println("results is empty");
			}	
			manageSearchResult(list);
		
			
		} catch (FlickrException e) {
			e.printStackTrace();
		}
	}
		public static void manageSearchResult(PhotoList<Photo> list) throws Exception {
			
			for (Photo photo : list) {
				
				if (photo != null){
				manageSingleEvent(photo);	
				}
				
			}
		}
					
		public static void manageSingleEvent(Photo photo){			
						
			GeoData geoData = new GeoData();
			FacadeGeoData fgd = new FacadeGeoDataImpl();
				            	           	            
			try {
				if(photo.getGeoData()!= null)				
				if((Float)photo.getGeoData().getLatitude() != null){
					
					
					geoData.setId(photo.getId());
					geoData.setPlatform("Flickr");
					geoData.setTitle(photo.getUrl());
					geoData.setBody(photo.getSmallUrl());
					geoData.setAuthor(photo.getOwner().getUsername());
					geoData.setDate(photo.getDateAdded());
					
					double[] coordinates = {photo.getGeoData().getLongitude(),photo.getGeoData().getLatitude()};
					Location location = new Location("Point",coordinates);
					geoData.setLocation(location);
										
					fgd.saveGeoData(geoData);
				}
										
			}catch (Exception e){
				
				e.printStackTrace();
			
			}
		}
	
}
	


