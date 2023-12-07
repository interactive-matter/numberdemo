package com.example.numberdemo.outputters;

import java.util.TreeMap;

//this was quite a nice implementation chatGPT came up with - like it
public class RomanOutputter implements Outputter {
    private static final TreeMap<Integer, String> ROMAN_MAP = new TreeMap<>(
            (a, b) -> b - a) {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    @Override
    public String apply(Integer number) {

        StringBuilder romanRepresentation = new StringBuilder();

        for (int value : ROMAN_MAP.keySet()) {
            while (number >= value) {
                romanRepresentation.append(ROMAN_MAP.get(value));
                number -= value;
            }
        }

        return romanRepresentation.toString();
    }
}
