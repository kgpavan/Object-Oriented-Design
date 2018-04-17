package design.practice.designEx.marsrover.main.com.github.javadojo;

import java.util.ArrayList;
import java.util.List;


public class PathFactory {

    private static List<Direction> listDirections;
    public static Path creatPath(String movements) {
        listDirections = new ArrayList<Direction>();
        List<Movement> listMovements = getListMovements(movements);
        Direction currentDirection = Direction.EAST;
        listDirections.add(currentDirection);
        
        for (Movement movement : listMovements) {
            Direction newDirection = currentDirection.getDirectionAfterMovement(movement);
            listDirections.add(newDirection);
            currentDirection = newDirection;
        }
        return new Path(listDirections);
    }
    
    private static List<Movement> getListMovements(String movements) {
        List<Movement> listMovements = new ArrayList<Movement>();
        for (int i = 0; i < movements.length(); i++) {
            Movement movement = Movement.getMovementByCode(movements.charAt(i)+"");
            listMovements.add(movement);
        }
        
        return listMovements;
    }

    
}
