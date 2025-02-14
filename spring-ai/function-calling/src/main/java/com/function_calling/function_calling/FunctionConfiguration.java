package com.function_calling.function_calling;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class FunctionConfiguration {

    private final WeatherconfigProperties props;

    @Bean
    @Description("get the current weather condition for the given city")
    public Function<WeatherService.Request, WeatherService.Response> currentWeatherFunction() {
        return new WeatherService(props);
    }
}
