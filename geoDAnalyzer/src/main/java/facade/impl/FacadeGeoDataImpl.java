package facade.impl;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import facade.FacadeGeoData;
import model.GeoData.GeoData;
import model.GeoData.Location;
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
	public List<JsonObject> getGeoDataProximity(Location location) {
		GeoDataRepository geoDataREP = new GeoDataMONGO();
		List<JsonObject> results = new ArrayList<JsonObject>();
		
		try{
			
			results = geoDataREP.findProximity(location);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}
		return results;
	}

	@Override
	public List<GeoData> getGeoDataWithinArea(double[][][][] multiPolygonArea) {
		GeoDataRepository geoDataREP = new GeoDataMONGO();
		List<GeoData> results = new ArrayList<GeoData>();
		try{
			
			results = geoDataREP.findWithinMultiPolygon(multiPolygonArea);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}
		return results;
	}
	

}
