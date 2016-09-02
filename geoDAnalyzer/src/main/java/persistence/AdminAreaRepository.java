package persistence;

import java.util.List;
import org.bson.types.ObjectId;
import model.AdministrativeArea.AdministrativeArea;
import model.GeoData.Location;

public interface AdminAreaRepository {
	
	AdministrativeArea getAdminAreaById(ObjectId _id);
	List<AdministrativeArea> findWhatMultiPolygon(Location location);


}
