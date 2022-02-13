package com;

public class Application {
    public static void main(String[] args) {
        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

        System.out.println("Result of recursive Calculate Fibonacci Numbers:");
        Printer printer = new Printer();
        for (int i = 1; i <= 30; i++) {
            printer.print(fibonacciCalculator.recursiveCalculateFibonacciNumbers(i));
        }
        System.out.println();
        System.out.println();

        System.out.println("Result of cycle Calculate Fibonacci Numbers:");
        fibonacciCalculator.cycleCalculateFibonacciNumbers(30);
    }
}
