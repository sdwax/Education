package com;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer [] integer = {2, 4, 7, 1, 4, 9};
        Double [] doubles = {2.3, 4.5, 7.5, 1.4, 4.6, 9.7};

        InsertionSorter insertionSorter = new InsertionSorter();
        insertionSorter.sort(integer);

        System.out.println("Sorted integer array: ");
        for (int i = 0; i < integer.length; i++) {
            System.out.println(integer[i]);
        }
        insertionSorter.sort(doubles);

        System.out.println("Sorted double array: ");
        for (int i = 0; i < integer.length; i++) {
            System.out.println(doubles[i]);
        }
    }
}
