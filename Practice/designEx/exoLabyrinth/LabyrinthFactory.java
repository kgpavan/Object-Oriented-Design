//package com.nespresso.sofa.recruitment.labyrinth;
package design.practice.designEx.exoLabyrinth;

import java.util.ArrayList;
import java.util.List;


public class LabyrinthFactory {
    
    private List<Room> listRooms;
    
    public List<Room> getLabyrinth(String[] listRoomsAndGates) {
        listRooms = new ArrayList<Room>();
        for (String twoRoomsAndGate : listRoomsAndGates) {
            Room firstRoom = getRoomsWithGate(twoRoomsAndGate)[0];
            Room secondRoom = getRoomsWithGate(twoRoomsAndGate)[1];
            
            Gate gate = getGate(twoRoomsAndGate);
            
            addRoomToListRooms(firstRoom, secondRoom, gate);
            addRoomToListRooms(secondRoom, firstRoom, gate);
        }
        return listRooms;
    }

    private void addRoomToListRooms(Room roomToAdd, Room roomNeighbor, Gate gate) {
        if(alreadyExistingRoom(roomToAdd)){
            int indexRoomToUpdate = listRooms.indexOf(roomToAdd);
            updateExistingRoom(indexRoomToUpdate, roomNeighbor, gate);
        }else
            listRooms.add(roomToAdd);
    }

    private boolean alreadyExistingRoom(Room newRoom) {
        for (Room room : listRooms) {
            if(room.equals(newRoom))
                return true;
        }
        return false;
    }

    private void updateExistingRoom(int indexRoom, Room room, Gate gate) {
        listRooms.get(indexRoom).addNeighbor(room, gate);
    }

    private Gate getGate(String twoRoomsAndGateAsString) {
        String[] twoRoomsAndGateAsArray = twoRoomsAndGateAsString.split("");
        Gate gate = Gate.getGateByCode(twoRoomsAndGateAsArray[2]);
        return gate;
    }

    private Room[] getRoomsWithGate(String twoRoomsAndGateAsString) {
        String[] twoRoomsAndGateAsArray = twoRoomsAndGateAsString.split("");
        Room room1 = new Room(twoRoomsAndGateAsArray[1]);
        Room room2 = new Room(twoRoomsAndGateAsArray[3]);
        Gate gate = getGate(twoRoomsAndGateAsString);
        room1.addNeighbor(room2, gate);
        room2.addNeighbor(room1, gate);
        
        return new Room[]{room1, room2};
    }

}
