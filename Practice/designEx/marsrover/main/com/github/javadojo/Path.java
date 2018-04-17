package design.practice.designEx.marsrover.main.com.github.javadojo;

import java.util.List;



public class Path {

    private List<Direction> directions;
    private PathPrinter pathPrinter;
    
    public Path(List<Direction> directions){
        this.directions = directions;
        pathPrinter = new PathPrinter();
    }

    public String print() {
        return pathPrinter.print(directions);
    }
    
    
}
