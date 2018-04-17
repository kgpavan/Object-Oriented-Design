package design.practice.aeroplane;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @author Thorsten Meinl, University of Konstanz
 */
public class Airport implements IAirport {

    private final PriorityQueue<IPlane> waitingPlanes = new PriorityQueue<IPlane>();
    private final List<IPlane> landedPlanes = new ArrayList<IPlane>();

    /**
     * {@inheritDoc}
     */
    // @Override
    public int getPlanesOnGround() {
        return landedPlanes.size();
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public int getPlanesWaiting() {

        return waitingPlanes.size();
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public void planeArriving(final IPlane plane) {

        waitingPlanes.add(plane);
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public void planeLanding(final IPlane plane) {
        waitingPlanes.remove(plane);
        landedPlanes.add(plane);
    }


    /**
     * {@inheritDoc}
     */
    // @Override
    public IPlane getNextPlaneToLand() {

        if (waitingPlanes.size() > 0) {

            return waitingPlanes.peek();
        } else {

            if (waitingPlanes.size() > 0) {
                return waitingPlanes.peek();
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {

        Airport zrh = new Airport();

        Airplane p1 = new Airplane("LX1234", 100, 5);
        Airplane p2 = new Airplane("LH1234", 100, 7);
        Airplane p3 = new Airplane("AB1234", 200, 7);


        zrh.planeArriving(p2);
        zrh.planeArriving(p1);
        zrh.planeArriving(p3);

        while (zrh.getPlanesWaiting() > 0) {

            IPlane p = zrh.getNextPlaneToLand();
            zrh.planeLanding(p);
            System.out.println(p + " ist gelandet");
        }
    }
}