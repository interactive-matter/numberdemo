package com.example.numberdemo.outputters

import spock.lang.Specification

class RomanOutputSpec extends Specification {
    def "test the output for roman numbers"() {

        def outputter = new RomanOutputter()

        expect:
        outputter.apply(a) == b

        where:
        a | b
        1 | "I"
        3 | "III"
        4 | "IV"
        9 | "IX"
        10 | "X"
        42 | "XLII"
        444 | "CDXLIV"
        999 | "CMXCIX"
        1234 | "MCCXXXIV"
        2023 | "MMXXIII"
    }
}