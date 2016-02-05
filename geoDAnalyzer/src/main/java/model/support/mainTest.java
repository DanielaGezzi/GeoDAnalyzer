package model.support;

import model.Location;
import persistence.mongo.GeoDataMONGO;

public class mainTest {
	
	public static void main (String[] args){
		
		GeoDataMONGO gdm = new GeoDataMONGO();
		Location location = new Location();
		location.setType("Point");
		double[] coord = {78.19383,24.17697};
		location.setCoordinates(coord);
		gdm.findProximity(location);
		
	}

}
