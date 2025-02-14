package com.function_calling.function_calling;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "weather")
public record WeatherconfigProperties(String apiKey, String apiUrl) {

}
