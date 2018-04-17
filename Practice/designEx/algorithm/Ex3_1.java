package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex3_1 {

    public static void main(String[] args) {
        String intervals = "[10,21] [1,3] [6,7] [8.4,12] [2,3] ";// ==> [8.4,21]
        System.out.println(longestInterval(parseIntervals(intervals)));
        
    }
    
    
    private static List<Interval> parseIntervals(String input) {
        List<Interval> listIntervals = new ArrayList<Interval>();
        Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = p.matcher(input);
        Double start = null;
        while(matcher.find()){
            if(start == null){
                start = Double.parseDouble(matcher.group());
            }else{
                Interval interval = new Interval(start, Double.parseDouble(matcher.group()));
                listIntervals.add(interval);
                start = null;
            }
        }
        return listIntervals;
    }
    
    private static Interval longestInterval(List<Interval> listInterval) {
        Stack<Interval> stackIntervals = intervalsWithoutOverlap(listInterval);
        
        Interval interval = stackIntervals.pop();
        while( ! stackIntervals.empty()){
            if(interval.narrowerThan(stackIntervals.peek())){
                interval = stackIntervals.pop();
            }else{
                stackIntervals.pop();
            }
        }
        
        return interval;
    }


    private static Stack<Interval> intervalsWithoutOverlap(List<Interval> listInterval) {
        Collections.sort(listInterval, Interval.INTERVAL_START_COMPARATOR);
        Stack<Interval> stackIntervals = new Stack<Interval>();
        stackIntervals.push(listInterval.get(0));
        for (int i = 1; i < listInterval.size(); i++) {
            if(stackIntervals.peek().overlapWith(listInterval.get(i))){
                Interval newInterval = stackIntervals.pop().merge(listInterval.get(i));
                stackIntervals.push(newInterval);
            }else{
                stackIntervals.push(listInterval.get(i));
            }
        }
        return stackIntervals;
    }
    
}
