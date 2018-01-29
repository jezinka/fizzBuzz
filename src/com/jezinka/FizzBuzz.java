package com.jezinka;

public class FizzBuzz {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            System.out.println(getOutput(i));
        }
    }

    private static String getOutput(Integer input) {

        if (input == null) {
            return "";
        }

        if (!isDivisibleBy3Or5(input)) {
            return input.toString();
        }

        return proceedFizzBuzz(input);
    }

    private static String proceedFizzBuzz(Integer input) {
        StringBuilder output = new StringBuilder();

        if (isDivisibleBy3(input)) {
            output.append("Fizz");
        }

        if (isDivisibleBy5(input)) {
            output.append("Buzz");
        }

        return output.toString();
    }

    private static boolean isDivisibleBy5(Integer input) {
        return input % 5 == 0;
    }

    private static boolean isDivisibleBy3(Integer input) {
        return input % 3 == 0;
    }

    private static boolean isDivisibleBy3Or5(Integer input) {
        return isDivisibleBy3(input) || isDivisibleBy5(input);
    }
}

