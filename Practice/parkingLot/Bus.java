//package Q7_04_Parking_Lot;
package design.practice.parkingLot;

public class Bus extends Vehicle {

	public Bus() {

		spotsNeeded = 5;
		size = VehicleSize.Large;
	}
	
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}
	
	public void print() {
		System.out.print("B");
	}
}
