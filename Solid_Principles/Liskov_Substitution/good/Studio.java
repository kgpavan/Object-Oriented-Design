package design.solid_principles.liskov_substitution.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class Studio {
    int squareFootage;
    int numberOfRooms;

    public Studio() {
        this.numberOfRooms = 0;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
