package crawler.twitter;

import twitter4j.conf.ConfigurationBuilder;

public class Login {
	
	public ConfigurationBuilder start() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setJSONStoreEnabled(true);
		
		cb.setOAuthConsumerKey("5tzGoXRsAQHXKiFBAdJg7AvQg");
		cb.setOAuthConsumerSecret("VgRj6Wpg68nXciqGrzASuqQpnp6Ik1pcs9lyYR7HjCVIn2JncV");
		cb.setOAuthAccessToken("271882972-C2vIeMqg76wOO2PVFRRCpbrH7QlZh4yRwpWoajKJ");
		cb.setOAuthAccessTokenSecret("xMPsGT0mEcRt0i6rENPBNmerco36zxme29cKxLglUSP58");

		return cb;
	}
}










