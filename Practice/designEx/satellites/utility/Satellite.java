package design.practice.designEx.satellites.utility;

public enum Satellite {

	ASTRA(19.2, "E"), HOTBIRD(13.0, "E"), NILESAT(7.0, "W");
	
	Satellite(Double Degree, String Orientation){
		this.Degree = Degree;
		this.Orientation = Orientation;
		
	}
	
	private Double Degree;
	private String Orientation;
	
	public Double getDegree(){
		return this.Degree;
	}
	
	public String getOrientation(){
		return this.Orientation;
	}
	
}
