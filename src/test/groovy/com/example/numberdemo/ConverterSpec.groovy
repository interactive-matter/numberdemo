package com.example.numberdemo

import com.example.numberdemo.inputters.Inputter
import spock.lang.Specification

class ConverterSpec extends Specification {
    def "test if registering inputs and outputs works"() {
        def converter = new Converter()

        when:
        converter.registerInputter "x", { number -> -1 }
        converter.registerOutputter "y", { number -> Integer.toString(number) }

        then:
        converter.convert("x", "y", "test") == "-1"

    }

    def "test if registering inputs twice leads to an exception"() {
        def converter = new Converter()

        when:
        converter.registerInputter "x", { number -> -1 }
        converter.registerOutputter "y", { number -> Integer.toString(number) }
        converter.registerInputter "x", { number -> -9 }


        then:
        thrown IllegalArgumentException

        and:
        converter.convert("x", "y", "test") == "-1"


    }


    def "test if registering outputters twice leads to an exception"() {
        def converter = new Converter()

        when:
        converter.registerInputter "x", { number -> -1 }
        converter.registerOutputter "y", { number -> Integer.toString(number) }
        converter.registerOutputter "y", { number -> "wrong" }

        then:
        thrown IllegalArgumentException

        and:
        converter.convert("x", "y", "test") == "-1"

    }

    def "test if accessing wrong inputs and outputs throws exception"() {
        def converter = new Converter()

        when:
        converter.registerInputter "x", { number -> -1 }
        converter.registerOutputter "y", { number -> Integer.toString(number) }

        and:
        converter.convert("a", "y", "test")

        then:
        thrown IllegalArgumentException

        when:
        converter.convert("x", "a", "test")

        then:
        thrown IllegalArgumentException

    }
}
