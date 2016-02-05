package crawler.facebook;

import facebook4j.conf.ConfigurationBuilder;

public class Login {

	
	public ConfigurationBuilder start() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setJSONStoreEnabled(true);
		
		cb.setOAuthAppId("*");
		cb.setOAuthAppSecret("*");
		cb.setOAuthAccessToken("*");
		cb.setOAuthPermissions("events");

		return cb;
	}
}