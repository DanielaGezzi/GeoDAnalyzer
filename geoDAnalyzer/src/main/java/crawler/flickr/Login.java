package crawler.flickr;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.REST;

public class Login {
	
	public Flickr start(){
	
		String appKey = "d6ef2c0b78ef64178bc9aa5a5484ab19";
		String appSecret = "000c75aaa37951b4";
		Flickr flickr = new Flickr(appKey, appSecret, new REST());
	
	return flickr;
	}

}
