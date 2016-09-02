package model.AdministrativeArea;

import java.util.Arrays;

public class Geometry {
	
	private String type;
	private double coordinates[][][][] ;
	
	public Geometry(){
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[][][][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(double[][][][] coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "Geometry [type=" + type + ", coordinates=" + Arrays.toString(coordinates) + "]";
	}
	
	
	

}
