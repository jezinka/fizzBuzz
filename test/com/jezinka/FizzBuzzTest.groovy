package com.jezinka

import org.springframework.boot.test.OutputCapture
import spock.lang.Specification

class FizzBuzzTest extends Specification {

    private static final String FIZZ_BUZZ = FizzBuzz.FIZZ + FizzBuzz.BUZZ

    @org.junit.Rule
    OutputCapture capture = new OutputCapture()

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
        FizzBuzz.FIZZ == output
    }

    def "getOutput(5) should return Buzz"() {
        when:
        def output = FizzBuzz.getOutput(5)
        then:
        FizzBuzz.BUZZ == output
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

        output        | input
        FizzBuzz.FIZZ | 3
        "2"           | 2
        FIZZ_BUZZ     | 30
        FizzBuzz.BUZZ | 10
        FizzBuzz.FIZZ | 99
        "17"          | 17
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

    def "test main method"() {
        given:
        final FizzBuzz fizzBuzz = new FizzBuzz()
        def range = FizzBuzz.RANGE_START..FizzBuzz.RANGE_END

        when:
        fizzBuzz.main()

        then:
        final List lines = capture.toString().tokenize(System.properties['line.separator'])

        lines.size() == FizzBuzz.RANGE_END - FizzBuzz.RANGE_START + 1

        lines.count { it == FIZZ_BUZZ } == range.count { it % 15 == 0 }
        lines.count { it == FizzBuzz.FIZZ } == range.count { it % 3 == 0 && it % 5 != 0 }
        lines.count { it == FizzBuzz.BUZZ } == range.count { it % 3 != 0 && it % 5 == 0 }
        lines.count { !(it in [FizzBuzz.BUZZ, FizzBuzz.FIZZ, FIZZ_BUZZ]) } == range.count { it % 3 != 0 && it % 5 != 0 }
    }
}

