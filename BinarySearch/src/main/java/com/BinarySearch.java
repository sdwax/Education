package com;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public <E extends Comparable<E>> boolean searchElement(List<E> array, E number) {
        int centerIndex = array.size() / 2;

        if (array.get(centerIndex).compareTo(number) == 0) {
            return true;
        }

        if (array.size() == 1) {
            return false;
        }

        List<E> newArray;
        if (number.compareTo(array.get(centerIndex)) < 0) {
            newArray = createNewArray(array, 0, centerIndex);
        } else {
            newArray = createNewArray(array, centerIndex, array.size());
        }
        return searchElement(newArray, number);
    }

    private <E> List<E> createNewArray(List<E> array, int startIndex, int endIndex) {
        int length = endIndex - startIndex;
        List<E> newArray = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            E element = array.get(startIndex + i);
            newArray.add(i, element);
        }
        return newArray;
    }
}
