package design.practice.designEx.exoLabyrinth;

import java.util.List;

public class Labyrinth {

    private List<Room> listRooms;
    private Room currentRoom;
    private Room lastVisitedRoom;
    private StringBuilder traversedSensors;
    
    public Labyrinth(String ...listRoomsAndGates) {
        LabyrinthFactory labyrinthFactory = new LabyrinthFactory();
        listRooms = labyrinthFactory.getLabyrinth(listRoomsAndGates);
        traversedSensors = new StringBuilder();
    }

    public void popIn(String roomName) {
        Room room = new Room(roomName);
        currentRoom = listRooms.get(listRooms.indexOf(room));
    }

    public void walkTo(String roomName){
        Room roomToWalkTo = new Room(roomName);
        if( ! listRooms.contains(roomToWalkTo) || ! currentRoom.isNeighbor(roomToWalkTo))
            throw new IllegalMoveException();
        else if(currentRoom.isGateClosedTo(roomToWalkTo))
            throw new ClosedDoorException();
        
        lastVisitedRoom = currentRoom;
        currentRoom = listRooms.get(listRooms.indexOf(roomToWalkTo));
        currentRoom.print(lastVisitedRoom, traversedSensors);
    }

    public void closeLastDoor() {
        if( ! currentRoom.isGateClosedTo(lastVisitedRoom)){
            currentRoom.closeGateTo(lastVisitedRoom);
            lastVisitedRoom.closeGateTo(currentRoom);
        }else
            throw new DoorAlreadyClosedException();
    }

    public String readSensors() {
        return traversedSensors.substring(0, traversedSensors.length() - 1);
    }

}
