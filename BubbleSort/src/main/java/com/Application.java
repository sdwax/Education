package com;

public class Application {
    public static void main(String[] args) {

        Integer [] integer = {2, 4, 7, 1, 4, 9};
        Double [] doubles = {2.3, 4.5, 7.5, 1.4, 4.6, 9.7};

        BubbleSorter bubbleSorter = new BubbleSorter();
        bubbleSorter.sort(integer);

        System.out.println("Sorted integer array: ");
        for (int i = 0; i < integer.length; i++) {
            System.out.println(integer[i]);
        }
        bubbleSorter.sort(doubles);

        System.out.println("Sorted double array: ");
        for (int i = 0; i < integer.length; i++) {
            System.out.println(doubles[i]);
        }
    }
}
