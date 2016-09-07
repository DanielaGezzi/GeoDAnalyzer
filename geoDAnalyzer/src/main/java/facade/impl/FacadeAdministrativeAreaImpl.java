package facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import facade.FacadeAdministrativeArea;
import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.Location;
import persistence.AdminAreaRepository;
import persistence.mongo.AdminAreaMONGO;

public class FacadeAdministrativeAreaImpl implements FacadeAdministrativeArea {
	
	@Override
	public List<AdministrativeArea> getGeoDataAdminArea(Location location){
		AdminAreaRepository adminDataREP = new AdminAreaMONGO();
		List<AdministrativeArea> results = new ArrayList<AdministrativeArea>();
		
		try{
			
			results = adminDataREP.findWhatMultiPolygon(location);
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}
		return results;
	}

	@Override
	public AdministrativeArea getAdministrativeArea(String _id) {
		ObjectId _id_area = new ObjectId(_id);
		AdminAreaRepository adminAreaREP = new AdminAreaMONGO();
		AdministrativeArea adminArea = new AdministrativeArea();
		
		try{
			
			adminArea = adminAreaREP.getAdminAreaById(_id_area);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return adminArea;
	}

}
