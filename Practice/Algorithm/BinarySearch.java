package design.practice.designEx.algorithm;
//package com.sqli.training.algo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> notSortedList = new ArrayList<Integer>();
        Collections.addAll(notSortedList, 6, 4, 8, 3, 7, 1, 8, 0);

        Collections.sort(notSortedList);

        boolean found = binarySercheFor(notSortedList, 90);
        System.out.println(found);
        System.out.println(notSortedList);
    }

    private static <T extends Comparable<T>> boolean binarySercheFor(List<T> notSortedList, T element) {
        return binarySearche(notSortedList, element, 0, notSortedList.size() - 1);
    }

    private static <T extends Comparable<T>> boolean binarySearche(List<T> notSortedList, T element, int start, int end) {
        if (end < start)
            return false;
        int midle = start + ((end - start) / 2);
        T elementInMiddle = notSortedList.get(midle);
        int resultComparaison = elementInMiddle.compareTo(element);
        if (resultComparaison == 0)
            return true;
        if (resultComparaison == 1)
            return binarySearche(notSortedList, element, start, midle - 1);
        else
            return binarySearche(notSortedList, element, midle + 1, end);
    }

}
