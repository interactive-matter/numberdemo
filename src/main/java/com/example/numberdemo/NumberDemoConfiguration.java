package com.example.numberdemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "conversion")
public class NumberDemoConfiguration {
    private Map<String, String> inputters;
    private Map<String, String> outputters;

}
