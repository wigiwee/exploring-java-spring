package com.function_calling.function_calling;

import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {

    private final WeatherconfigProperties weatherProps;
    private final RestClient restClient;

    public WeatherService(WeatherconfigProperties weatherProps) {
        this.weatherProps = weatherProps;
        this.restClient = RestClient.create(weatherProps.apiUrl());
    }

    public record Request(String city) {
    }

    public record Response(Location location, Current current) {
    }

    public record Location(String name, String region, String country, Long lat, Long lon) {
    }

    public record Current(String temp_f, Condition condition, String wind_mpt, String humidity) {
    }

    public record Condition(String text) {
    }

    @Override
    public Response apply(Request request) {
        log.info("Weather Request: {}", request);
        Response response = restClient.get()
                .uri(uribuilder -> uribuilder
                        .path("/current.json")
                        .queryParam("key", weatherProps.apiKey())
                        .queryParam("q", request.city()).build())
                .retrieve()
                .body(Response.class);
        log.info("Weather API response : {}", response);
        return response;
    }
}
