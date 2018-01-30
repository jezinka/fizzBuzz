package com.jezinka

import spock.lang.Specification

class FizzBuzzTest extends Specification {

    private static final String FIZZ = "Fizz"
    private static final String BUZZ = "Buzz"
    private static final String FIZZ_BUZZ = "FizzBuzz"

    def "getOutput should not throw NullPointerException"() {
        when:
        FizzBuzz.getOutput()

        then:
        notThrown(NullPointerException)
    }

    def "getOutput(1) should return 1"() {
        when:
        def output = FizzBuzz.getOutput(1)

        then:
        1.toString() == output
    }

    def "getOutput(3) should return Fizz"() {
        when:
        def output = FizzBuzz.getOutput(3)

        then:
        FIZZ == output
    }

    def "getOutput(5) should return Buzz"() {
        when:
        def output = FizzBuzz.getOutput(5)
        then:
        BUZZ == output
    }

    def "getOutput(15) should return FizzBuzz"() {
        when:
        def output = FizzBuzz.getOutput(15)
        then:
        FIZZ_BUZZ == output
    }

    def "test getOutput for some values"() {
        expect:
        output == FizzBuzz.getOutput(input)

        where:

        output    | input
        FIZZ      | 3
        "2"       | 2
        FIZZ_BUZZ | 30
        BUZZ      | 10
        FIZZ      | 99
        "17"      | 17
    }

    def "isDivisibleBy3Or5 return true if number is divisible by 3 or 5 false otherwise"() {
        when:
        def isDivisible = FizzBuzz.isDivisibleBy3Or5(i)

        then:
        isDivisible == expected

        where:
        i  | expected
        3  | true
        5  | true
        15 | true
        1  | false
        7  | false
        11 | false
        30 | true
    }

    def "isDivisibleBy should return true if number is divisible by divider false otherwise"() {
        when:
        def isDivisible = FizzBuzz.isDivisibleBy(i, divider)

        then:
        isDivisible == expected

        where:
        i  | divider | expected
        3  | 3       | true
        5  | 5       | true
        15 | 5       | true
        1  | 2       | false
        7  | 4       | false
        11 | 5       | false
        20 | 10      | true
    }
}

