package com;

public class Printer {
    private int count = 1;
    private int countGoToNextLine = 1;
    private int countPrintingNumbers = 1;

    public void print(int number) {
        System.out.print(number + " ");

        if (countPrintingNumbers == countGoToNextLine) {
            System.out.println();
            count++;
            countGoToNextLine = count + countGoToNextLine;
        }
        countPrintingNumbers++;
    }
}
