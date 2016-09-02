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
	public AdministrativeArea getAdministrativeArea(ObjectId _id) {
		// TODO Auto-generated method stub
		return null;
	}

}
