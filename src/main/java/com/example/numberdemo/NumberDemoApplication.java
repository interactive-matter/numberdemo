package com.example.numberdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NumberDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberDemoApplication.class, args);
	}

	@Bean
	public ConversionController conversionController(Converter converter) {
		return new ConversionController(converter);
	}

	@Bean
	public Converter converter() {
		return new Converter();
	}
}
