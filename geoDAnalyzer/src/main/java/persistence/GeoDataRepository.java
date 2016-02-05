package persistence;

import java.util.List;

import model.GeoData;
import model.Location;

public interface GeoDataRepository {
	
	void saveGeoData(GeoData geoData);
	List<GeoData> findProximity(Location location);

	
}
