package design.practice.designEx.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Ex1 {

    public static void main(String[] args) {
        String integerSequence = "123450234560234567";
        List<Integer> listInteger = getNumbersAsList(integerSequence);
        List<Integer> longestIncreasingSubsequence = longestIncreasingSubsequence(listInteger);
        
        for (Integer integer : longestIncreasingSubsequence) {
            System.out.print(integer);
        }
    }
    
    /**
     * TODO : to be completed
     * */
    private static Stack<Integer> longestIncreasingSubsequenceSTACK(List<Integer> numbers){
        Stack<Integer> highestStack = new Stack<Integer>();
        Stack<Integer> currentStack = new Stack<Integer>();
        currentStack.push(numbers.get(0));
        for (Integer integer : currentStack){
            if(integer == currentStack.peek() + 1 || currentStack.empty()){
                currentStack.push(integer);
            }else if(currentStack.size() > highestStack.size()){
                currentStack.clear();
            }
        }
        return highestStack;
    }
    private static List<Integer> longestIncreasingSubsequence(List<Integer> numbers){
        
        List<Integer> sequenceOfInt = new ArrayList<Integer>();
        List<Integer> longestSequence = new ArrayList<Integer>();
        
        for (int i = 0, j = 1; j < numbers.size(); i++, j++) {
            if(numbers.get(i) + 1 == numbers.get(j)){
                sequenceOfInt.add(numbers.get(i));
            }else if(sequenceOfInt.size() > longestSequence.size()){
                sequenceOfInt.add(numbers.get(i));
                longestSequence.clear();
                longestSequence.addAll(sequenceOfInt);
                sequenceOfInt.clear();
            }
        }
        return longestSequence;
    }
    
    private static List<Integer> getNumbersAsList(String integerSequence) {
        String [] integerArray = integerSequence.split("");
        List<Integer> listInteger = new ArrayList<Integer>();
        
        for (int i = 1; i < integerArray.length; i++) {
            listInteger.add(Integer.parseInt(integerArray[i]));
        }
        System.out.println(listInteger);
        return listInteger;
    }
}
