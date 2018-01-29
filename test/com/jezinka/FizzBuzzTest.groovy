package com.jezinka

import spock.lang.Specification

class FizzBuzzTest extends Specification {

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
        "Fizz" == output
    }

    def "getOutput(5) should return Buzz"() {
        when:
        def output = FizzBuzz.getOutput(5)
        then:
        "Buzz" == output
    }

    def "getOutput(15) should return FizzBuzz"() {
        when:
        def output = FizzBuzz.getOutput(15)
        then:
        "FizzBuzz" == output
    }

    def "test getOutput for some values"() {
        expect:
        output == FizzBuzz.getOutput(input)

        where:

        output     | input
        "Fizz"     | 3
        "2"        | 2
        "FizzBuzz" | 30
        "Buzz"     | 10
        "Fizz"     | 99
        "17"       | 17
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

    def "isDivisibleBy3 should return true if number is divisible by 3 false otherwise"() {
        when:
        def isDivisible = FizzBuzz.isDivisibleBy3(i)

        then:
        isDivisible == expected

        where:
        i  | expected
        3  | true
        5  | false
        15 | true
        1  | false
        7  | false
        11 | false
    }

    def "isDivisibleBy5 return true if number is divisible by 5 false otherwise"() {
        when:
        def isDivisible = FizzBuzz.isDivisibleBy5(i)

        then:
        isDivisible == expected

        where:
        i  | expected
        3  | false
        5  | true
        15 | true
        1  | false
        7  | false
        11 | false
    }
}

