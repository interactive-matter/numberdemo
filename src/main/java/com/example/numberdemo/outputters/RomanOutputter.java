package com.example.numberdemo.outputters;

import java.util.TreeMap;

//this was quite a nice implementation chat GPT cam up with - like it
public class RomanOutputter implements Outputter{
    private static final TreeMap<Integer, String> ROMAN_MAP = new TreeMap<>((a, b) -> b - a);

    static {
        ROMAN_MAP.put(1000, "M");
        ROMAN_MAP.put(900, "CM");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(400, "CD");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(90, "XC");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(40, "XL");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(9, "IX");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(1, "I");
    }
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
