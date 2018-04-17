package com.sourcemaking.adapter.second_example;

/**
 * Another Adapter source code example
 * Identify the desired interface.
 * Design a "wrapper" class that can "impedance match" the old to the new.
 * The adapter/wrapper class "has a" instance of the legacy class.
 * The adapter/wrapper class "maps" (or delegates) to the legacy object.
 * The client uses (is coupled to) the new interface.
*/

class SquarePeg {

    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}

class RoundHole {
    private final int radius;

    public RoundHole(int radius) {
        this.radius = radius;
        System.out.println("RoundHole: max SquarePeg is " + radius * Math.sqrt(2));
    }

    public int getRadius() {
        return radius;
    }
}

class SquarePegAdapter {
    private final SquarePeg squarePeg;

    public SquarePegAdapter(double w) {
        squarePeg = new SquarePeg(w);
    }

    public void makeFit(RoundHole roundHole) {
        double amount = squarePeg.getWidth() - roundHole.getRadius() * Math.sqrt(2);
        System.out.println( "reducing SquarePeg " + squarePeg.getWidth() + " by " + ((amount < 0) ? 0 : amount) + " amount");
        if (amount > 0) {
            squarePeg.setWidth(squarePeg.getWidth() - amount);
            System.out.println("   width is now " + squarePeg.getWidth());
        }
    }
}

public class AdapterDemoSquarePeg {

    public static void main( String[] args ) {

        RoundHole roundHole = new RoundHole( 5 );
        SquarePegAdapter squarePegAdapter;

        for (int i = 6; i < 10; i++) {
            squarePegAdapter = new SquarePegAdapter((double)i);
            squarePegAdapter.makeFit(roundHole);
        }
    }
}
