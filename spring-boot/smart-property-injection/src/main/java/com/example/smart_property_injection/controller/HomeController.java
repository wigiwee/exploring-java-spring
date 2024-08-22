package com.example.smart_property_injection.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.smart_property_injection.configuration.ApplicationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HomeController {

    @Autowired
    ApplicationProperties applicationProperties;

    @GetMapping("/home")
    public String getProp () {
        
        return applicationProperties.getTest() +" " + applicationProperties.getEncryptionStrength();
    }
    
}
