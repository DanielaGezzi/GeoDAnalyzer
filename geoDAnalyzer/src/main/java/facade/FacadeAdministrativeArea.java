package facade;

import java.util.List;
import org.bson.types.ObjectId;
import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.Location;

public interface FacadeAdministrativeArea {
	
	public AdministrativeArea getAdministrativeArea(ObjectId _id);
	public List<AdministrativeArea> getGeoDataAdminArea(Location location);
	


}
