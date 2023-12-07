package com.example.numberdemo.inputters;

public class DecimalInputter implements Inputter {
    @Override
    public Integer apply(String number) {
        return Integer.parseInt(number);
    }
}
