package facade;

import java.util.List;
import model.GeoData.GeoData;
import model.GeoData.Location;

public interface FacadeGeoData {
	
	public void saveGeoData(GeoData geoData);
	public List<GeoData> getGeoDataProximity(Location location);
	public List<GeoData> getGeoDataWithinArea(double[][][][] multiPolygonArea);

}
