package facade;

import java.util.List;
import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.Location;

public interface FacadeAdministrativeArea {
	
	public AdministrativeArea getAdministrativeArea(String _id);
	public List<AdministrativeArea> getGeoDataAdminArea(Location location);
	


}
