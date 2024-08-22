package com.example.smart_property_injection.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
@Configuration
@ConfigurationProperties(prefix = "server.com")
public class ApplicationProperties {

    private String encryptionStrength = "default"; 

    private String test = "testDefault";

}
