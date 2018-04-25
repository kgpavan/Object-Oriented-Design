package com.sourcemaking.flyweight.first_example.before;

/**
 * Discussion. Trying to use objects at very low levels of
 * granularity is nice, but the overhead may be prohibitive.
 * Flyweight suggests removing the non-shareable state from
 * the class, and having the client supply it when methods
 * are called. This places more responsibility on the client,
 * but, considerably fewer instances of the Flyweight class
 * are now created. Sharing of these instances is facilitated
 * by introducing a Factory class that maintains a "cache" of
 * existing Flyweights.
 */

class Gazillion {
    private static int num = 0;
    private int row, col;

    public Gazillion(int maxPerRow) {
        row = num / maxPerRow;
        col = num % maxPerRow;
        num++;
    }

    void report() {
        System.out.print(" " + row + col);
    }
}

public class FlyweightDemo {
    public static final int ROWS = 6, COLS = 10;

    public static void main( String[] args ) {
        Gazillion[][] matrix = new Gazillion[ROWS][COLS];
        for (int i=0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                matrix[i][j] = new Gazillion(COLS);
            }
        }
        for (int i=0; i < ROWS; i++) {
            for (int j=0; j < COLS; j++) {
                matrix[i][j].report();
            }
            System.out.println();
        }
    }
}
