package com;

public class FibonacciCalculator {
    public void cycleCalculateFibonacciNumbers(int limit) {
        Printer printer = new Printer();

        int previous = 0;
        int current = 1;
        printer.print(current);

        int sum;
        for (int i = 0; i < limit - 1; i++) {
            sum = previous + current;
            previous = current;
            current = sum;

            printer.print(sum);

        }
    }

    public int recursiveCalculateFibonacciNumbers(int limit) {
        if (limit == 0) return 0;
        if (limit == 1) return 1;

        return recursiveCalculateFibonacciNumbers(limit - 2) + recursiveCalculateFibonacciNumbers(limit - 1);
    }
}
