package design.practice.designEx.parking;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder class to get a parking instance
 */
public class ParkingBuilder {

    private List<ParkingLane> parkingLanes;
    
	public ParkingBuilder withSquareSize(final int size) {
        parkingLanes = new ArrayList<ParkingLane>(size);
        for (int i = 0; i < size; i++) {
			ParkingLane parkingLane = new ParkingLane(size);
			parkingLanes.add(parkingLane);
		}
        
        return this;
    }

    public ParkingBuilder withPedestrianExit(final int pedestrianExitIndex) {
        int laneIndex = pedestrianExitIndex / parkingLanes.size();
        int surfaceIndex = pedestrianExitIndex % parkingLanes.size();
        ParkingLane parkingLane = parkingLanes.get(laneIndex);
        parkingLane.addPedestrianExit(surfaceIndex);
        return this;
    }

    public ParkingBuilder withDisabledBay(final int disabledBayIndex) {
    	int laneIndex = disabledBayIndex / parkingLanes.size();
        int surfaceIndex = disabledBayIndex % parkingLanes.size();
        ParkingLane parkingLane = parkingLanes.get(laneIndex);
        parkingLane.addEmptyDisabledBay(surfaceIndex);
        return this;
    }

    public Parking build() {
        return new Parking(parkingLanes);
    }
}
