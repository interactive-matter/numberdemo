package com.example.numberdemo.inputters

import com.example.numberdemo.outputters.RomanOutputter
import spock.lang.Specification


class BinaryInputSpec extends Specification {
    def inputter = new BinaryInputter()

    def "test the input for binary numbers"() {

        expect:
        inputter.apply(a) == b

        where:
        a        | b
        "0"      | 0
        "1"      | 1
        "11"     | 3
        "1000"   | 8
        "10100"  | 20
        "101010" | 42
    }

    def "test the input for invalid number"() {

        when:
        inputter.apply("9")

        then:
        thrown(NumberFormatException)

        when:
        inputter.apply("Quatsch")

        then:
        thrown(NumberFormatException)
    }
}