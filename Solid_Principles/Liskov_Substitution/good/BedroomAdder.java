package design.solid_principles.liskov_substitution.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class BedroomAdder {
    public void addBedroom(PenthouseSuite penthouse) {
        penthouse.numberOfBedrooms += 1;
    }
}
