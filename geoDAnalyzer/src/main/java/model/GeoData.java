package model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class GeoData {
	private Object _id;
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
	
	public GeoData(String id, String platform, String title, String author, 
			String body, Date date, Location location){
		
		this.id = id;
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
		return "GeoData [id=" + id + ", platform=" + platform + ", title=" + title + ", author=" + author + ", body="
				+ body + ", date=" + date + "," + location + "]";
	}
	@XmlTransient
	public String get_id() {
		return (String) _id;
	}
	@XmlTransient
	public void set_id(String _id) {
		this._id = _id;
	}
}
