package model.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import crawler.facebook.CrawlerF;

public class StartSearch {
	
	public static void main (String[] args){
		
		System.out.println("Enter params for the search:");
		InputStreamReader reader = new InputStreamReader (System.in);
		BufferedReader myInput = new BufferedReader (reader);
		String queryParam = new String ();
		
		try {
			
			queryParam = myInput.readLine();
			CrawlerF.startSearch(queryParam);
			//CrawlerT.startSearch(queryParam);
						
		} catch (IOException e) {
				
			e.printStackTrace();
			System.exit(-1); 
			
		} catch (Exception e){
			
			e.printStackTrace();
			System.exit(-1);
			
		}
			
	}  

}
