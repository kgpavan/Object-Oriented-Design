package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.List;


public class QuickSort {

    public static void main(String[] args) {
        List<Integer> listIntegers = new ArrayList<Integer>();
        listIntegers.add(12);
        listIntegers.add(2);
        listIntegers.add(120);
        listIntegers.add(30);
        listIntegers.add(12);
        listIntegers.add(55);
        List<Integer> sorted = quickSort(listIntegers);
        System.out.println(listIntegers);
        System.out.println(sorted);
    }
    
    public static List<Integer> quickSort(List<Integer> list) {
        if(list == null || list.size() <= 1)
            return list;
        Integer pivot = list.get(0);
        List<Integer> greaterThenPivot = new ArrayList<Integer>();
        List<Integer> lesserThenPivot = new ArrayList<Integer>();
        
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) <= pivot){
                lesserThenPivot.add(list.get(i));
            }else{
                greaterThenPivot.add(list.get(i));
            }
        }
        List<Integer> returnedList = new ArrayList<Integer>();
        returnedList.addAll(quickSort(lesserThenPivot));
        returnedList.add(pivot);
        returnedList.addAll(quickSort(greaterThenPivot));
        
        return returnedList;
    }
}
