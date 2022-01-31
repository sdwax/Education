package com;

public class BubbleSorter {
    public <T extends Comparable<T>> void sort(T[] array) {
        boolean needIterable;
        do {
            needIterable = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    swap(array, i - 1, i);
                    needIterable = true;
                }
            }
        } while (needIterable);
    }

    private void swap(Object[] array, int currentIndex, int nextIndex) {
        Object temp = array[currentIndex];
        array[currentIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
