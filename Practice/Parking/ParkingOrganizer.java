package design.practice.designEx.parking;

import java.util.ArrayList;
import java.util.List;


public class ParkingOrganizer {

    public int parkCar(List<ParkingLane> parkingLaneList, char carType) {
        List<Integer> distancesFromFreePositionToPedestrianExit = getDistancesList(parkingLaneList, carType);
        int laneToParkIndex = getLaneIndexToParkCar(distancesFromFreePositionToPedestrianExit);
        int withinLaneToParkIndex = parkingLaneList.get(laneToParkIndex).parkCar(carType);
        if(withinLaneToParkIndex != -1)
            return withinLaneToParkIndex + (laneToParkIndex * parkingLaneList.size());
        else
            return -1;
    }

    private List<Integer> getDistancesList(List<ParkingLane> parkingLaneList, char carType) {
        List<Integer> distancesList = new ArrayList<Integer>();
        for (ParkingLane parkingLane : parkingLaneList) {
            int closestFreeIndexInLane = parkingLane.closestDistanceFromFreePositionToPedestrianExit(carType);
            distancesList.add(closestFreeIndexInLane);
        }
        return distancesList;
    }

    private int getLaneIndexToParkCar(List<Integer> distances) {
        int lastDistanceIndex = distances.size() - 1;
        int minimunDistance = lastDistanceIndex;
        int selectedLaneIndex = lastDistanceIndex;
        for (int i = lastDistanceIndex; i >= 0; i--) {
            if(distances.get(i) != -1 && distances.get(i) <= minimunDistance){
               minimunDistance = distances.get(i);
               selectedLaneIndex = i;
            }
        }
        return selectedLaneIndex;
    }

    public boolean unpark(List<ParkingLane> parkingLaneList, int index) {
        int parkingLaneIndex = index / parkingLaneList.size();
        int indexCarWithinLane = index % parkingLaneList.size();
        return parkingLaneList.get(parkingLaneIndex).unparkCar(indexCarWithinLane);
    }

}
