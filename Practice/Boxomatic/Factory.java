package design.practice.designEx.boxomatic;

import java.util.ArrayList;
import java.util.List;


public class Factory {

    public static List<Interval> getIntervals(int... intervalsLength) {
        List<Interval> intervals = new ArrayList<Interval>();
        int currentStartNumber = 0;
        
        for (int i = 0; i < intervalsLength.length; i++) {
            Interval interval = new Interval(currentStartNumber, intervalsLength[i]);
            intervals.add(interval);
            currentStartNumber += intervalsLength[i];
        }
        return intervals;
    }

    public static char[] generateLabels() {
        return "ABC".toCharArray();
    }

}
