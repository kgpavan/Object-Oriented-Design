package design.practice.designEx.boxomatic;

import java.util.List;


public class Boxomatic {

//  private Map<String, Interval> intervals;
    private List<Interval> intervals;
    private char[] labels;
    
    public Boxomatic(int ...intervals) {
        this.intervals = Factory.getIntervals(intervals);
        this.labels = Factory.generateLabels();
    }

    public String printLabelForIndex(int number) {
        for (Interval interval : intervals) {
            if(interval.isNumberInInterval(number)){
                return printLabel(number, interval);
            }
        }
        return "";
    }

    private String printLabel(int number, Interval interval) {
        char labelCharPart = getLabelOfInterval(interval);
        String labelNumericPart = getIntervalOrder(number, interval);
        
        return labelCharPart + labelNumericPart;
    }

    private String getIntervalOrder(int number, Interval interval) {
        return Integer.toString(interval.getNumberOrder(number));
    }

    private char getLabelOfInterval(Interval interval) {
        return labels[intervals.indexOf(interval)];
    }
    
    

}
