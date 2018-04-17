package design.solid_principles.liskov_substitution.bad.src;

/**
 * Created by mrk on 4/8/14.
 */
public class PenthouseSuite extends Apartment {
    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}
