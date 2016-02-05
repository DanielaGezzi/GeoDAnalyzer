package crawler.twitter;

import java.util.List;
import facade.FacadeGeoData;
import facade.impl.FacadeGeoDataImpl;
import model.GeoData;
import model.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class CrawlerT {
	
	private static final int TWEETS_FOR_PAGE = 100;

	
	public static void startSearch(String queryParam) throws Exception {
		/*auth in order to access twitter dev*/
		Login login = new Login(); 
		ConfigurationBuilder cb = login.start();
		
		TwitterFactory ft = new TwitterFactory(cb.build());
		Twitter twitter = ft.getInstance();

		Query query = new Query(queryParam).resultType(Query.ResultType.mixed);  //mixed: Include both popular and real time results in the response.
		query.setCount(TWEETS_FOR_PAGE);
		query.setLang("it");

		long lastStatus = 1;
		long penultimateStatus = 0 ; 
		
		do {
			try {		
				//for (int page = 0; page < SEARCH_MAX_PAGE; page++) {
				QueryResult result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				if (tweets.isEmpty()) {
					break;
				}	
				manageQueryResult(tweets);
				penultimateStatus = lastStatus;
				lastStatus = tweets.get(tweets.size()-1).getId();
				query.maxId(lastStatus);
				
			}
			catch(TwitterException e) {
				if(e.exceededRateLimitation() && e.getStatusCode()==429) {
					System.out.println("Rate Limit Exceeded");
					System.out.println(e.getRetryAfter());
					System.out.println(e.getErrorCode());
					Thread.sleep((e.getRetryAfter()+61)*1000);
				}
			}
		}
		while (query!= null && lastStatus!=penultimateStatus);	
	}
	
	public static void manageQueryResult(List<Status> tweets) throws Exception {
		
		for (Status status : tweets) {
			
			manageSingleTweet(status);	
			
			}
		}
			
	
	public static void manageSingleTweet(Status status){	
		
		GeoData geoData = new GeoData();
		FacadeGeoData fgd = new FacadeGeoDataImpl();

		     
		try {
			if(status.getGeoLocation()!= null){
				
				geoData.setId(String.valueOf(status.getId()));
				geoData.setPlatform("Twitter");
				geoData.setTitle("");
				geoData.setBody(status.getText());
				geoData.setAuthor(status.getUser().getName());
				geoData.setDate(status.getCreatedAt());
				
				double[] coordinates = {status.getGeoLocation().getLongitude(),status.getGeoLocation().getLatitude()};
				Location location = new Location("Point",coordinates);
				geoData.setLocation(location);
				
				fgd.saveGeoData(geoData);

			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}

	}

	public static void main(String[] args){
		try {
			startSearch("evento");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
