package facade;

import java.util.List;


import model.GeoData;
import model.Location;

public interface FacadeGeoData {
	
	public void saveGeoData(GeoData geoData);
	public List<GeoData> getGeoDataProximity(Location location);

}
