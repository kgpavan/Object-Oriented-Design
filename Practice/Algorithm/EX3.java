package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EX3 {

    public static void main(String[] args) {
        String intervals = "[10,21] [1,3] [6,7] [8.4,12] [2,3] ";// ==> [8.4,21]
        System.out.println(getLongestInterval(parseIntervals(intervals)));
        
    }
    
    
    private static List<Interval> parseIntervals(String input) {
        List<Interval> intervalies = new ArrayList<Interval>();
        Pattern p = Pattern.compile("\\d+(\\.\\d)?");
        Matcher m = p.matcher(input);
        Double start = null;
        while(m.find()){
            if(start == null){
                start = Double.parseDouble(m.group());
            }else{
                Interval i = new Interval(start, Double.parseDouble(m.group()));
                intervalies.add(i);
            }
        }
        return intervalies;

    }
    
    private static Interval getLongestInterval(List<Interval> intervals) {
        Stack<Interval> stack = intervalsWithoutOverlap(intervals);
        
        Interval longestInterval = stack.pop();
        while( ! stack.empty()){
            if(longestInterval.narrowerThan(stack.peek())){
                longestInterval = stack.pop();
            }else{
                stack.pop();
            }
        }
        
        return longestInterval;
    }


    private static Stack<Interval> intervalsWithoutOverlap(List<Interval> intervals) {
        Collections.sort(intervals, Interval.INTERVAL_START_COMPARATOR);
        Stack<Interval> stack = new Stack<Interval>();
        stack.push(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            if(stack.peek().overlapWith(intervals.get(i))){
                Interval newInterval = stack.pop().merge(intervals.get(i));
                stack.push(newInterval);
            }else{
                stack.push(intervals.get(i));
            }
        }
        return stack;
    }
}
