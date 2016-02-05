package crawler.twitter;

import twitter4j.conf.ConfigurationBuilder;

public class Login {
	
	public ConfigurationBuilder start() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setJSONStoreEnabled(true);
		
		cb.setOAuthConsumerKey("*");
		cb.setOAuthConsumerSecret("*");
		cb.setOAuthAccessToken("*");
		cb.setOAuthAccessTokenSecret("*");

		return cb;
	}
}










