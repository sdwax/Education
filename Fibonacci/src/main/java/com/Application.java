package com;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

        ArrayList<Integer> fibonacciNumbersOne = new ArrayList<>();
        fibonacciCalculator.recursiveCalculateFibonacciNumbers(fibonacciNumbersOne, 5);

        List<Integer> fibonacciNumbersTwo = fibonacciCalculator.cycleCalculateFibonacciNumbers(5);

        System.out.println("Result of recursive Calculate Fibonacci Numbers:");
        for (Integer numbers : fibonacciNumbersOne) {
            System.out.println(numbers);
        }

        System.out.println("Result of cycle Calculate Fibonacci Numbers:");
        for (Integer numbers : fibonacciNumbersTwo) {
            System.out.println(numbers);
        }
    }
}
