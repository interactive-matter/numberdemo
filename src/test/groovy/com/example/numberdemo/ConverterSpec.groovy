package com.example.numberdemo

import com.example.numberdemo.inputters.Inputter
import spock.lang.Specification

class ConverterSpec extends Specification{
    def "test if registering inuts and outputs worka"() {
        def converter = new Converter()

        when:
        converter.registerInputter "x", { number -> -1}
        converter.registerOutputter "y", {number -> Integer.toString(number)}

        then:
        converter.convert ("x","y","test") == test

    }
}
