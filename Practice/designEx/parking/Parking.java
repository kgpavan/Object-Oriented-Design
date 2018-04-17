package design.practice.designEx.parking;

import java.util.List;

/**
 * Handles the parking mechanisms: park/unpark a car (also for disabled-only bays) and provides a string representation of its state.
 */
public class Parking {

	private List<ParkingLane> parkingLaneList;
	private ParkingOrganizer parkingOrganizer;
	
	public Parking(List<ParkingLane> parkingLaneList){
		this.parkingLaneList = parkingLaneList;
		parkingOrganizer = new ParkingOrganizer();
	}
    /**
     * @return the number of available parking bays left
     */
    public int getAvailableBays() {
        int availableBaysCount = 0;
    	for (ParkingLane parkingLane : parkingLaneList) {
			availableBaysCount += parkingLane.getAvailableBays();
		}
        return availableBaysCount;
    }

    /**
     * Park the car of the given type ('D' being dedicated to disabled people) in closest -to pedestrian exit- and first (starting from the parking's entrance)
     * available bay. Disabled people can only park on dedicated bays.
     *
     *
     * @param carType
     *            the car char representation that has to be parked
     * @return bay index of the parked car, -1 if no applicable bay found
     */
    public int parkCar(final char carType) {
    	return parkingOrganizer.parkCar(parkingLaneList, carType);
    }

    /**
     * Unpark the car from the given index
     *
     * @param index
     * @return true if a car was parked in the bay, false otherwise
     */
    public boolean unparkCar(final int index) {
        return parkingOrganizer.unpark(parkingLaneList, index);
    }

    /**
     * Print a 2-dimensional representation of the parking with the following rules:
     * <ul>
     * <li>'=' is a pedestrian exit
     * <li>'@' is a disabled-only empty bay
     * <li>'U' is a non-disabled empty bay
     * <li>'D' is a disabled-only occupied bay
     * <li>the char representation of a parked vehicle for non-empty bays.
     * </ul>
     * U, D, @ and = can be considered as reserved chars.
     *
     * Once an end of lane is reached, then the next lane is reversed (to represent the fact that cars need to turn around)
     *
     * @return the string representation of the parking as a 2-dimensional square. Note that cars do a U turn to continue to the next lane.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        boolean reverseOrder = false;
        for (ParkingLane parkingLane : parkingLaneList) {
			parkingLane.print(builder, reverseOrder);
			reverseOrder = reverseOrder ? false : true;
			if( ! parkingLane.equals(parkingLaneList.get(parkingLaneList.size() - 1)))
				builder.append("\n");
		}
        return builder.toString();
    }

}
