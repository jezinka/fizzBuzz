package com.jezinka;

public class FizzBuzz {

    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int FIVE = 5;

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String EMPTY_STRING = "";

    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;

    public static void main(String[] args) {

        for (int i = RANGE_START; i <= RANGE_END; i++) {
            System.out.println(getOutput(i));
        }
    }

    private static String getOutput(Integer input) {

        if (input == null) {
            return EMPTY_STRING;
        }

        if (!isDivisibleBy3Or5(input)) {
            return input.toString();
        }

        return proceedFizzBuzz(input);
    }

    private static String proceedFizzBuzz(Integer input) {
        StringBuilder output = new StringBuilder();

        if (isDivisibleBy(input, THREE)) {
            output.append(FIZZ);
        }

        if (isDivisibleBy(input, FIVE)) {
            output.append(BUZZ);
        }

        return output.toString();
    }

    private static boolean isDivisibleBy(Integer input, Integer divider) {
        return input % divider == ZERO;
    }

    private static boolean isDivisibleBy3Or5(Integer input) {
        return isDivisibleBy(input, THREE) || isDivisibleBy(input, FIVE);
    }
}

