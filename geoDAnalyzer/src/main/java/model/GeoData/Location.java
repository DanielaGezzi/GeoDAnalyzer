package model.GeoData;

import java.util.Arrays;

public class Location {
	private String type;
	private double coordinates[] ;
	
	public Location(){
		super();
	}
	
	public Location(String type, double[] coordinates){
		this.type = type;
		this.coordinates = coordinates;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Location [type=" + type + ", coordinates=" + Arrays.toString(coordinates) + "]";
	}
	
}
