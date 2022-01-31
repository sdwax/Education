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

    public void recursiveCalculateFibonacciNumbers(List<Integer> result, int limit) {
        int previous = 0;
        int current = 1;
        result.add(previous);
        result.add(current);

        calculateFibonacciNumbers(result, previous, current, limit - 2);
    }

    private void calculateFibonacciNumbers(List<Integer> result, int previous, int current, int limit) {
        if (limit == 0) {
            return;
        }
        int sum = previous + current;
        result.add(sum);

        calculateFibonacciNumbers(result, current, sum, limit - 1);
    }
}
