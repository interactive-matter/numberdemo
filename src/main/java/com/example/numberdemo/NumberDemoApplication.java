package com.example.numberdemo;

import com.example.numberdemo.inputters.Inputter;
import com.example.numberdemo.outputters.Outputter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(NumberDemoConfiguration.class)
public class NumberDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberDemoApplication.class, args);
	}


	@Bean
	public ConversionController conversionController(Converter converter) {
		return new ConversionController(converter);
	}

	@Bean
	public Converter converter(NumberDemoConfiguration configuration) {
		Converter converter = new Converter();
		for (Map.Entry<String,String> e :configuration.getInputters().entrySet()) {
			converter.registerInputter(e.getKey(), (Inputter) instantiate(e.getValue()));
		}
		for (Map.Entry<String,String> e :configuration.getOutputters().entrySet()) {
			converter.registerOutputter(e.getKey(), (Outputter) instantiate(e.getValue()));
		}
		return converter;
	}


	private Object instantiate(String clazzName) {
		try {
			return Class.forName(clazzName).getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException e) {
			//for this heavy configuration error we accept a double log entry
			log.error("Unable to instantiate {}",clazzName,e);
			throw new RuntimeException(e);
		}
    }

}
