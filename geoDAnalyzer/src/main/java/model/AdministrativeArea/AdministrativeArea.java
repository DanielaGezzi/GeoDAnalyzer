package model.AdministrativeArea;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;

@XmlRootElement
public class AdministrativeArea {
	
	private ObjectId _id;
	private String type;
	private Properties properties;
	private Geometry geometry;
	
	public AdministrativeArea(){
		super();
	}

	public Object get_id() {
		return _id;
	}

	public void set_id(Object _id) {
		this._id = (ObjectId) _id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public String toString() {
		return "AdministrativeArea [_id=" + _id + ", type=" + type + "," + properties + "," 
				+ geometry + "]";
	}
	

}
