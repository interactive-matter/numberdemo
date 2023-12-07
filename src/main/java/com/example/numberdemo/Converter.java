package com.example.numberdemo;

import com.example.numberdemo.inputters.Inputter;
import com.example.numberdemo.outputters.Outputter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Slf4j
public class Converter {
    private final Map<String, Inputter> inputters = new HashMap<>();
    private final Map<String, Outputter> outputters = new HashMap<>();

    public final void registerInputter(String name, Inputter inputter) {
        Inputter current = inputters.putIfAbsent(name, inputter);
        if (current != null) {
            throw new IllegalArgumentException("There is already an inputter named " + name + ":" + current);
        }
    }

    public void registerOutputter(String name, Outputter outputter) {
        Outputter current = outputters.putIfAbsent(name, outputter);
        if (current != null) {
            throw new IllegalArgumentException("There is already an outputter named " + name + ":" + current);
        }
    }

    public String convert(String inputter, String outputter, String number) {
        Integer intRep = ofNullable(inputters.get(inputter)).map(i -> i.apply(number)).orElseThrow(
                () -> new IllegalArgumentException("There is no inputter by the name `" + inputter + "`")
        );
        String result = ofNullable(outputters.get(outputter)).map(o -> o.apply(intRep)).orElseThrow(
                () -> new IllegalArgumentException("There is no outputter by the name `" + inputter + "`")
        );
        log.info("Read {} with {} to {}. Converting it to {} with {}", number, inputter, intRep, result, outputter);
        return result;
    }
}
