package design.solid_principles.liskov_substitution.bad.src;

/**
 * Created by mrk on 4/8/14.
 */
abstract class Apartment {
    int squareFootage;
    int numberOfBedrooms;

    abstract void setSquareFootage(int sqft);
}
