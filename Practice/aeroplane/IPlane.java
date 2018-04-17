package design.practice.aeroplane;


/**
 * This interface describes an airplane.
 */
public interface IPlane extends Comparable<IPlane> {
    /**
     * Returns the liters of fuel that remain.
     *
     * @return the liter of remaining fuel
     */
    public double getRemainingFuel();

    /**
     * Returns the number of passengers on the plane.
     *
     * @return the number of passengers
     */
    public int getPassengerCount();

    /**
     * Returns the flight's code, e.g. LX1234 or AB7777
     *
     * @return the flight code
     */
    public String getFlightCode();
}
