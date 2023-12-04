class RomanOutputSpec extends Specification {
    def "test the output for roman numbers"() {

        def outputter = new RomanOutputter()

        expect:
        outputter.convert(a) == b

        where:
        a | b
        1 | "I"
        3 | "III"
        4 | "IV"
        9 | "IX"
        10 | "X"
        42 | "XLII"
        1234 | "MCCXXXIV"
        2023 | "MMXXIII"
    }
}