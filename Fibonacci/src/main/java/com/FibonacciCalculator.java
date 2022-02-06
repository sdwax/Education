package com;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCalculator {
    public List<Integer> cycleCalculateFibonacciNumbers(int limit) {
        final List<Integer> result = new ArrayList<>();

        int previous = 0;
        int current = 1;
        result.add(previous);
        result.add(current);

        int sum;
        for (int i = 0; i < limit - 2; i++) {
            sum = previous + current;
            previous = current;
            current = sum;

            result.add(sum);
        }
        return result;
    }

    public int calculateFibonacciNumbers(int limit) {
        if (limit == 0) return 0;
        if (limit == 1) return 1;

        return calculateFibonacciNumbers(limit - 2) + calculateFibonacciNumbers(limit - 1);
    }
}
