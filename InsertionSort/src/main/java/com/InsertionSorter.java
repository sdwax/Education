package com;

public class InsertionSorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                for (int j = i; j > 0; j--) {
                    if (array[j - 1].compareTo(array[j]) > 0) {
                        swap(array, j - 1, j);
                    }
                }
            }
        }
    }

    private void swap(Object[] array, int currentIndex, int nextIndex) {
        Object temp = array[currentIndex];
        array[currentIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
