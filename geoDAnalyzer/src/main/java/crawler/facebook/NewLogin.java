package crawler.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

public class NewLogin {
	public Facebook Logger(){
	Configuration configuration = createConfiguration();
	FacebookFactory ff = new FacebookFactory(configuration);
	Facebook facebookClient = ff.getInstance();
	AccessToken accessToken = new AccessToken("CAAJBcfobqGIBAOVWrl1POBQ1gMCzgnGa29DFGqhg1KIaGkhwpJlFwM5AhOflEfbFN0KGVdCdrNtzL596B92DiyfCOmxJk3EZCi8tvVdsOODZCaKXtNRka4vXebnm5Bc0atBXs8LB2OoLaLIvqCsJMFpe1EoAZAQGEOKuGJakC3wfZCSZAz4CUFpYpfObCLRU7ZCGfyAdrA9QZDZD");
	
	/*try{
		OAuthSupport oAuthSupport = new OAuthAuthorization(configuration);
		accessToken = oAuthSupport.getOAuthAppAccessToken();
		System.out.println(accessToken);
	}catch (FacebookException e){
		System.out.println("error while creating access token" + e.getLocalizedMessage());
	}*/
	facebookClient.setOAuthAccessToken(accessToken);
	return facebookClient;
			
}

public Configuration createConfiguration(){
	ConfigurationBuilder cb = new ConfigurationBuilder();
	
	cb.setDebugEnabled(true);
	cb.setJSONStoreEnabled(true);
	cb.setUseSSL(true);
	cb.setOAuthAppId("634907736647778");
	cb.setOAuthAppSecret("b83f3acfe102420946fc0517a7dd14ef");
	cb.setOAuthPermissions("events");
	
	Configuration configuration = cb.build();
	return configuration;
	
}
}
