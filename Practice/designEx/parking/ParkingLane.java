package design.practice.designEx.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLane {
	
	private List<Surface> surfaces;
	
	public ParkingLane(int size){
		surfaces = createNewEmptyLane(size);
	}

	private List<Surface> createNewEmptyLane(int size) {
		List<Surface> surfaces = new ArrayList<Surface>();
		for (int i = 0; i < size; i++) {
			Surface emptyNonDisabledBay = new NonDisabledBay();
			surfaces.add(emptyNonDisabledBay);
		}
		return surfaces;
	}

	public void addPedestrianExit(int surfaceIndex) {
		PedestrianExit pedestrianExit = new PedestrianExit();
		surfaces.remove(surfaceIndex);
		surfaces.add(surfaceIndex, pedestrianExit);
	}

	public void addEmptyDisabledBay(int surfaceIndex) {
		DisabledBay disabledBay = new DisabledBay(false);
		surfaces.remove(surfaceIndex);
		surfaces.add(surfaceIndex, disabledBay);
	}

	public int getAvailableBays() {
		int availableBaysCount = 0;
		for (Surface surface : surfaces) {
			if(surface instanceof Fillable && ((Fillable) surface).isEmpty())
				availableBaysCount++;
		}
		return availableBaysCount;
	}
	
	public void print(StringBuilder builder, boolean reverseOrder){
		List<Surface> surfaces = new ArrayList<Surface>(this.surfaces);
		if(reverseOrder)
			Collections.reverse(surfaces);
		
		for (Surface surface : surfaces) {
			surface.print(builder);
		}
	}

	public int closestDistanceFromFreePositionToPedestrianExit(char carType){
		Surface surface = createSurface(carType);
		int pedestrianExitIndex = getPedestrainExitPosition();
		int closestFreePositionBeforePedestrianExit = closestFreePositionBeforePedestrianExit(pedestrianExitIndex, surface);
		int closestFreePositionAfterPedestrianExit = closestFreePositionAfterPedestrianExit(pedestrianExitIndex, surface);
		return getMinimumDistanceToPedestrianExit(pedestrianExitIndex, closestFreePositionBeforePedestrianExit, closestFreePositionAfterPedestrianExit);
		
	}

	public int closestFreePositionToPedestrianExit(Surface surface){
        int pedestrianExitIndex = getPedestrainExitPosition();
        int closestFreePositionBeforePedestrianExit = closestFreePositionBeforePedestrianExit(pedestrianExitIndex, surface);
        int closestFreePositionAfterPedestrianExit = closestFreePositionAfterPedestrianExit(pedestrianExitIndex, surface);
        if(closestFreePositionBeforePedestrianExit != -1 && closestFreePositionAfterPedestrianExit !=-1){
            int distanceBefore = pedestrianExitIndex - closestFreePositionBeforePedestrianExit;
            int distanceAfter = closestFreePositionAfterPedestrianExit - pedestrianExitIndex;
            if(distanceBefore <= distanceAfter)
                return closestFreePositionBeforePedestrianExit;
            else
                return closestFreePositionAfterPedestrianExit;
        }else if(closestFreePositionBeforePedestrianExit != -1)
            return closestFreePositionBeforePedestrianExit;
        else
            return closestFreePositionAfterPedestrianExit;
	}
	private int getMinimumDistanceToPedestrianExit(int pedestrianExitIndex, int beforeIndex, int afterIndex) {
		if(beforeIndex != -1 && afterIndex != -1){
			int beforeDistance = Math.abs(pedestrianExitIndex - beforeIndex);
			int afterDistance = Math.abs(pedestrianExitIndex - afterIndex);
			return Math.min(beforeDistance, afterDistance);
		}else if(beforeIndex != -1)
			return Math.abs(pedestrianExitIndex - beforeIndex);
		else if(afterIndex != -1)
			return Math.abs(pedestrianExitIndex - afterIndex);
		else
		    return -1;
	}
	
	private int closestFreePositionAfterPedestrianExit(int pedestrianExitIndex, Surface surface) {
		for (int i = pedestrianExitIndex + 1; i < surfaces.size() && pedestrianExitIndex != -1; i++) {
			Surface currentSurface = surfaces.get(i);
			if( currentSurface.canAccept(surface) && currentSurface instanceof Fillable && 
					((Fillable) currentSurface).isEmpty())
				return i;
		}
		return -1;
	}

	private int closestFreePositionBeforePedestrianExit(int pedestrianExitIndex, Surface surface) {
		for (int i = pedestrianExitIndex - 1; i >= 0; i--) {
			Surface currentSurface = surfaces.get(i);
			if( currentSurface.canAccept(surface) && currentSurface instanceof Fillable && 
					((Fillable) currentSurface).isEmpty())
				return i;
		}
		return -1;
	}

	private int getPedestrainExitPosition() {
		for (int i = 0; i < surfaces.size(); i++) {
			if(surfaces.get(i).canAccept(new PedestrianExit()))
				return i;
		}
		return -1;
	}

	public int parkCar(char carType) {
	    Surface surface = createSurface(carType);
	    int indexToPark = closestFreePositionToPedestrianExit(surface);
	    if(indexToPark != -1){
	        surfaces.remove(indexToPark);
		    surfaces.add(indexToPark, surface);
	    }
		return indexToPark;
	}
	
	private Surface createSurface(char carType){
		if(carType == 'D'){
			return new DisabledBay(true);
		}else
			return new NonDisabledBay(carType);
	}

    public boolean unparkCar(int indexWithinLane) {
        if(surfaces.get(indexWithinLane) instanceof Fillable && ! ((Fillable)surfaces.get(indexWithinLane)).isEmpty()){
            ((Fillable)surfaces.get(indexWithinLane)).free();
            return true;
        }else
            return false;
    }

}
