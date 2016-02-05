package crawler.flickr;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;

public class Login {
	
	public Flickr start(){
	
		String appKey = "*";
		String appSecret = "*";
		Flickr flickr = new Flickr(appKey, appSecret, new REST());
	
	return flickr;
	}

}
