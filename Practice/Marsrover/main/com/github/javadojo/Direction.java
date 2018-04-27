package design.practice.designEx.marsrover.main.com.github.javadojo;


public enum Direction {
    
    NORTH {

        @Override
        public Direction getDirectionAfterMovement(Movement movement) {
            if(movement == Movement.LEFT)
                return EAST;
            else if(movement == Movement.RIGHT)
                return WEST;
            return NORTH;
        }

        @Override
        public String print(Direction previousDirection) {
            if(previousDirection == this || previousDirection == SOUTH)
                return MarsRover.LINE_SEPARATOR+"|";
            else
                return "+";
        }
    }, SOUTH {

        @Override
        public Direction getDirectionAfterMovement(Movement movement) {
            if(movement == Movement.LEFT)
                return WEST;
            else if(movement == Movement.RIGHT)
                return EAST;
            return SOUTH;
        }

        @Override
        public String print(Direction previousDirection) {
            if(previousDirection == this || previousDirection == NORTH)
                return MarsRover.LINE_SEPARATOR+"|";
            else
                return "+";
        }
    }, EAST {

        @Override
        public Direction getDirectionAfterMovement(Movement movement) {
            if(movement == Movement.LEFT)
                return NORTH;
            else if(movement == Movement.RIGHT)
                return SOUTH;
            return EAST;
        }

        @Override
        public String print(Direction previousDirection) {
            if(previousDirection == this || previousDirection == WEST)
                return "-";
            else
                return "+";
        }
    }, WEST {

        @Override
        public Direction getDirectionAfterMovement(Movement movement) {
            if(movement == Movement.LEFT)
                return SOUTH;
            else if(movement == Movement.RIGHT)
                return NORTH;
            return WEST;
        }

        @Override
        public String print(Direction previousDirection) {
            if(previousDirection == this || previousDirection == EAST)
                return "-";
            else
                return "+";
        }
    };

    
    public abstract Direction getDirectionAfterMovement(Movement movement);

    public abstract String print(Direction previousDirection);

}
