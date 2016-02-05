package facade.impl;

import java.util.ArrayList;
import java.util.List;


import facade.FacadeGeoData;
import model.GeoData;
import model.Location;
import persistence.GeoDataRepository;
import persistence.mongo.GeoDataMONGO;

public class FacadeGeoDataImpl implements FacadeGeoData {

	@Override
	public void saveGeoData(GeoData geoData) {
		GeoDataRepository geoDataREP = new GeoDataMONGO();
		
		try{
			
			geoDataREP.saveGeoData(geoData);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public List<GeoData> getGeoDataProximity(Location location) {
		GeoDataRepository geoDataREP = new GeoDataMONGO();
		List<GeoData> results = new ArrayList<GeoData>();
		
		try{
			
			results = geoDataREP.findProximity(location);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}
		return results;
	}

}
