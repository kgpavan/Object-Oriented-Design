package design.practice.designEx.satellites.model;

import design.practice.designEx.satellites.utility.Satellite;

public class Canal {
	private String canalName;
	private Satellite canalSattelite;
	
	public Canal(String canalName, Satellite canalSatellite){
		this.canalName = canalName;
		this.canalSattelite = canalSatellite;
	}

	public Satellite getCanalSattelite() {
		return canalSattelite;
	}
	
	

}
