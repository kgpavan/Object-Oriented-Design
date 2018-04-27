package design.practice.designEx.marsrover.main.com.github.javadojo;

import java.util.List;
import static design.practice.designEx.marsrover.main.com.github.javadojo.MarsRover.LINE_SEPARATOR;


public class PathPrinter {

    private static final String STARTING_POSITION = "X";
    private static final String CURRENT_POSITION = "*";
    private static boolean isPrintingOrderReversed = false;
    
    public String print(List<Direction> directions) {
        StringBuilder builder = new StringBuilder(STARTING_POSITION);
        for (int i = 1; i < directions.size(); i++) {
            reversePrintingOrder(directions.get(i-1), directions.get(i));
            if(isPrintingOrderReversed){
                builder.insert(0, printStep(i, directions));
            }
            builder.append(printStep(i, directions));
        }
        builder.append(LINE_SEPARATOR);
        return builder.toString();
    }

    private void reversePrintingOrder(Direction currentDirection, Direction previousDirection) {
        if((currentDirection == Direction.EAST || currentDirection == Direction.WEST) && 
                (previousDirection == Direction.NORTH || previousDirection == Direction.SOUTH))
            isPrintingOrderReversed = true;
        else if((currentDirection == Direction.NORTH|| currentDirection == Direction.SOUTH) && 
                (previousDirection == Direction.EAST  || previousDirection == Direction.WEST))
            isPrintingOrderReversed = true;
        else{
            isPrintingOrderReversed = false;
        }
    }

    private String printStep(int currentDirectionIndex, List<Direction> directions) {
        if(currentDirectionIndex == directions.size() - 1)
            return CURRENT_POSITION;
        Direction previousDirection = directions.get(currentDirectionIndex);
        return directions.get(currentDirectionIndex).print(previousDirection);
    }

}
