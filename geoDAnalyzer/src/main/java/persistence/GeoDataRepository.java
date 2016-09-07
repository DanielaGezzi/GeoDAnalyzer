package persistence;

import java.util.List;

import com.google.gson.JsonObject;

import model.AdministrativeArea.Geometry;
import model.GeoData.GeoData;
import model.GeoData.Location;

public interface GeoDataRepository {
	
	void saveGeoData(GeoData geoData);
	List<JsonObject> findProximity(Location location);
	//List<GeoData> findProximity(Location location);
	List<GeoData> findWithinMultiPolygon (Geometry geometry);

	
}
