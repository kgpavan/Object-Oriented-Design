package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ex4 {

    public static void main(String[] args) {
        String intervals = "[2.2, 21] [1,3.3]";
        List<Interval> listIntervales = parseIntervals(intervals);
        
        char c = 'D';
        if(c > 'A' && c < 'Z')
            System.out.println("Upper");
        else
            System.out.println("Lower");
        
        
        for (Interval intervale : listIntervales) {
            System.out.print(intervale+" ");
        }
        Interval longestIntervale = longestInterval(listIntervales);
        System.out.println("\n"+longestIntervale);
    }

    private static List<Interval> parseIntervals(String intervals) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(intervals);
        Double intervalStart = null;
        List<Interval> listIntervales = new ArrayList<Interval>();
        while (matcher.find()) {
            if(intervalStart == null){
                intervalStart = Double.parseDouble(matcher.group());
            }else{
                Interval intervale = new Interval(intervalStart, Double.parseDouble(matcher.group()));
                listIntervales.add(intervale);
                intervalStart = null;
            }
        }
        return listIntervales;
    }
    
    public static Interval longestInterval(List<Interval> intervals){
        Stack<Interval> intervalStack = intervalsWithoutOverlap(intervals);
        Interval longestIntervale = intervalStack.pop();
        while( ! intervalStack.empty()){
            if(longestIntervale.narrowerThan(intervalStack.peek())){
                longestIntervale = intervalStack.pop();
            }else{
                intervalStack.pop();
            }
        }
        return longestIntervale;
    }

    private static Stack<Interval> intervalsWithoutOverlap(List<Interval> intervals) {
        Collections.sort(intervals, Interval.INTERVAL_START_COMPARATOR);
        Stack<Interval> intervalStack = new Stack<Interval>();
        intervalStack.push(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if(intervalStack.peek().overlapWith(intervals.get(i))){
                Interval newIntervale =  intervalStack.pop().merge(intervals.get(i));
                intervalStack.push(newIntervale);
            }else{
                intervalStack.push(intervals.get(i));
            }
        }
        return intervalStack;
    }
}
