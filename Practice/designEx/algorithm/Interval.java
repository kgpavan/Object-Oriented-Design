package design.practice.designEx.algorithm;

import java.util.Comparator;


public class Interval {

    private double start;
    private double end;
    public static final Comparator<Interval> INTERVAL_START_COMPARATOR = new Comparator<Interval>() {

        // @Override
        public int compare(Interval o1, Interval o2) {
            return (int) (o1.start - o2.start);
        }
    };

    public static final Comparator<Interval> INTERVAL_LENGTH_COMPARATOR = new Comparator<Interval>() {

        // @Override
        public int compare(Interval o1, Interval o2) {
            return (int) (o1.start - o2.start);
        }
    };

    public Interval(double satrt, double end) {
        super();
        this.start = satrt;
        this.end = end;
    }


    public boolean overlapWith(Interval intervale) {
        if (this.contains(intervale.start) || this.contains(intervale.end)) {
            return true;
        }
        return false;
    }


    private boolean contains(double point) {
        if (this.start <= point || this.end >= point) {
            return true;
        }
        return false;
    }

    public Interval merge(Interval intervale) {
        return new Interval(Math.min(this.start, intervale.start), Math.max(this.end, intervale.end));
    }


    public boolean narrowerThan(Interval intervale) {
        return (this.end - this.start) < (intervale.end - intervale.start);

    }

    @Override
    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }

}
