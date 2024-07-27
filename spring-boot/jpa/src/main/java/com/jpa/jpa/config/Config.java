package com.jpa.jpa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan( basePackages = {"com.jpa"})     
// @EnableJpaRepositories( basePackages = {"in.repositories", "com.jpa.jpa"})   //to use repositories in different package
public class Config {

}
