package crawler.facebook;

import facebook4j.conf.ConfigurationBuilder;

public class Login {

	
	public ConfigurationBuilder start() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setJSONStoreEnabled(true);
		
		cb.setOAuthAppId("634907736647778");
		cb.setOAuthAppSecret("b83f3acfe102420946fc0517a7dd14ef");
		cb.setOAuthAccessToken("CAACEdEose0cBABHWyvZAqAdurYNj0kkdZBzHu68uYiM3HWuHvSxVtZC8YDBisg3f31DgSAxknm2zup7NFcZBqCiZAWaEu6JM403GqSJ0DiuH6LZARcuH79fZAJXjKjr1s269e6vqpNGEFScqgANY4HWR3mZCTbZCQV96gZBKmh49EmLk1MiWaSkAPJ8Nyg4ZAsPz54e0W5ZB3K88JwZDZD");
		cb.setOAuthPermissions("events");

		return cb;
	}
}