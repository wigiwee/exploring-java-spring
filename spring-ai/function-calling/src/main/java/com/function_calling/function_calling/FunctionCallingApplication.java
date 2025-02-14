package com.function_calling.function_calling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(WeatherconfigProperties.class)
@SpringBootApplication
public class FunctionCallingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionCallingApplication.class, args);
	}

}
