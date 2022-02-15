package com;

public class InsertionSorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        boolean needIterable = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                for (int j = i; j > 0 && needIterable; j--) {
                    needIterable = false;
                    if (array[j - 1].compareTo(array[j]) > 0) {
                        swap(array, j - 1, j);
                        needIterable = true;
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
