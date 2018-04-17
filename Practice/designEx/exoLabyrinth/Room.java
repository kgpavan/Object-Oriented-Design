//package com.nespresso.sofa.recruitment.labyrinth;
package design.practice.designEx.exoLabyrinth;

import java.util.HashMap;
import java.util.Map;


public class Room{

    private String name;
    private Map<Room, Gate> openGateNeighborRooms;
    private Map<Room, Gate> closedGateNeighborRooms;
    
    
    public Room(String name) {
        this.name = name;
        openGateNeighborRooms = new HashMap<Room, Gate>();
        closedGateNeighborRooms = new HashMap<Room, Gate>();
    }


    public void addNeighbor(Room room, Gate gate) {
        openGateNeighborRooms.put(room, gate);
    }

    @Override
    public boolean equals(Object object)
    {
        if(object != null && object instanceof Room){
            return this.name.equals(((Room)object).name);
        }
        return false;
    }


    public boolean isNeighbor(Room neighborRoom) {
        return openGateNeighborRooms.containsKey(neighborRoom) 
                || closedGateNeighborRooms.containsKey(neighborRoom);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        return prime + ((name == null) ? 0 : name.hashCode());
    }

    public void removeNeighbor(Room neighborRoom) {
        openGateNeighborRooms.remove(neighborRoom);
        
    }

    public void closeGateTo(Room neighborRoom) {
        Gate gate = openGateNeighborRooms.get(neighborRoom);
        openGateNeighborRooms.remove(neighborRoom);
        closedGateNeighborRooms.put(neighborRoom, gate);
    }


    public boolean isGateClosedTo(Room neighborRoom) {
        return closedGateNeighborRooms.containsKey(neighborRoom);
    }


    public void print(Room neighborRoom, StringBuilder traversedSensors) {
        Gate gate = openGateNeighborRooms.get(neighborRoom);
        if(gate == Gate.WithSensor)
            traversedSensors.append(neighborRoom.name + this.name + ";");
        
    }
}
