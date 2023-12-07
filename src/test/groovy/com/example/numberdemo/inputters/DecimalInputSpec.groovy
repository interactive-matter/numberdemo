package com.example.numberdemo.inputters


import spock.lang.Specification

class DecimalInputSpec extends Specification {
    def inputter = new DecimalInputter()

    def "test the input for decimal numbers"() {

        expect:
        inputter.apply(a) == b

        where:
        a    | b
        "0"  | 0
        "1"  | 1
        "11" | 11
        "9"  | 9
        "42" | 42
    }

    def "test the input for invalid number"() {

        when:
        inputter.apply("Quatsch")

        then:
        thrown(NumberFormatException)
    }
}