package model.GeoData;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.bson.types.ObjectId;

@XmlRootElement
public class GeoData {
	private ObjectId _id;
	private ObjectId _idAdminArea;
	private String id;
	private String platform;
	private String title;
	private String author;
	private String body;
	private Date date;
	private Location location;
	
	public GeoData(){
		super();
	}
	
	public GeoData(String id, ObjectId _idAdminArea, String platform, String title, String author, 
			String body, Date date, Location location){
		
		this.id = id;
		this._idAdminArea = _idAdminArea;
		this.platform = platform;
		this.title = title;
		this.author = author;
		this.body = body;
		this.date = date;
		this.location = location;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public ObjectId get_idAdminArea() {
		return _idAdminArea;
	}

	public void set_idAdminArea(ObjectId _idAdminArea) {
		this._idAdminArea = _idAdminArea;
	}

	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "GeoData [id=" + id + ", idArea=" + _idAdminArea.toString() + ", platform=" + platform + ", title=" + title + ", author=" + author + ", body="
				+ body + ", date=" + date + "," + location + "]";
	}
	@XmlTransient
	public ObjectId get_id() {
		return (ObjectId) _id;
	}
	@XmlTransient
	public void set_id(ObjectId _id) {
		this._id = (ObjectId) _id;
	}
}
