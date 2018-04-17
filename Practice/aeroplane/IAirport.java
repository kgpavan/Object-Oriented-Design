package design.practice.aeroplane;

/**
 * This class describes an airport.
 */
public interface IAirport {
    /**
     * Returns the number of planes that are on the airport on the ground.
     *
     * @return the number of planes on the ground.
     */
    public int getPlanesOnGround();

    /**
     * Returns the number of planes waiting to land on the airport.
     *
     * @return the number of planes waiting in the sky
     */
    public int getPlanesWaiting();

    /**
     * A plane approaching the airport and wanting to land must call this method.
     *
     * @param plane any plane
     */
    public void planeArriving(IPlane plane);

    /**
     * A plane that is on the airport must call this method.
     *
     * @param plane any plane
     */
    public void planeLanding(IPlane plane);


    /**
     * Returns the next plane in the queue that is allowed to land. The queue order is determined by
     * {@link IPlane#compareTo(IPlane)}. If no plane is currently waiting, <code>null</code> is returned.
     *
     * @return a plane or <code>null</code>
     */
    public IPlane getNextPlaneToLand();
}
