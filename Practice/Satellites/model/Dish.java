package design.practice.designEx.satellites.model;

import design.practice.designEx.satellites.utility.Satellite;

public class Dish {
	
	private int Id;
	private Double OrientationDegree;
	private String Orientation;			//Means E/W (East or West)

	public Dish(int Id, Double OrientationDegree,String Orientation){
		this.Id = Id;
		this.OrientationDegree = OrientationDegree;
		this.Orientation = Orientation;
	}

	public Double getDishSatelliteSignalDifference(Satellite satellite){
		
		return Math.abs(this.OrientationDegree - satellite.getDegree());
		
	}
	public void move(Double DegreeOfMovement, String OrientationOfMouvement){
		
		if(this.Orientation.equals(OrientationOfMouvement)){
			this.OrientationDegree = this.OrientationDegree + DegreeOfMovement;
		}else{
			this.OrientationDegree = Math.abs(this.OrientationDegree - DegreeOfMovement);
		}
	}
}
