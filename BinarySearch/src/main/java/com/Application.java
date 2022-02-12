package com;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchElement(array, 1));
        System.out.println(binarySearch.searchElement(array, 8));
        System.out.println(binarySearch.searchElement(array, 12));
        System.out.println(binarySearch.searchElement(array, 5));
    }
}
