package design.practice.aeroplane;


/**
 * @author Thorsten Meinl, University of Konstanz
 */
public class Airplane implements IPlane {

    private double remainingFuel;

    private int passengerCount;

    private final String flightCode;

    public Airplane(final String flightCode, final int passengerCount, final double remainingFuel) {
        this.flightCode = flightCode;
        this.passengerCount = passengerCount;
        this.remainingFuel = remainingFuel;
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public int compareTo(final IPlane o) {

        int diff = (int) Math.signum(this.remainingFuel - o.getRemainingFuel());
        if (diff != 0) {
            return diff;
        }
        diff = o.getPassengerCount() - this.passengerCount;
        if (diff != 0) {
            return diff;
        }

        return this.flightCode.compareTo(o.getFlightCode());
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public double getRemainingFuel() {
        return remainingFuel;
    }

    /**
     * {@inheritDoc}
     */
    // @Override
    public int getPassengerCount() {

        return passengerCount;
    }


    /**
     * {@inheritDoc}
     */
    // @Override
    public String getFlightCode() {

        return flightCode;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return "Flight " + flightCode + " with " + passengerCount + " passengers has " + remainingFuel + " fuel left";
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {

        if (!(obj instanceof IPlane)) {

            return false;
        }

        if (!(obj instanceof IPlane)) {
            return false;
        }
        IPlane p = (IPlane) obj;
        return (this.passengerCount == p.getPassengerCount())
                && (this.remainingFuel == p.getRemainingFuel())
                && this.flightCode.equals(p.getFlightCode());
    }
}



