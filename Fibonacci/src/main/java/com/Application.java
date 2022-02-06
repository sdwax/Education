package com;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();
        List<Integer> fibonacciNumbers = fibonacciCalculator.cycleCalculateFibonacciNumbers(5);

        System.out.println("Result of recursive Calculate Fibonacci Numbers:");
        System.out.println(fibonacciCalculator.recursiveCalculateFibonacciNumbers(5));

        System.out.println("Result of cycle Calculate Fibonacci Numbers:");
        for (Integer numbers : fibonacciNumbers) {
            System.out.println(numbers);
        }
    }
}
