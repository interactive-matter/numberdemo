package com.example.numberdemo.inputters;

public class BinaryInputter implements Inputter {
    @Override
    public Integer apply(String number) {
        return Integer.parseInt(number, 2);
    }
}
