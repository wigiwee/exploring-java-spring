package com.security.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("home")
    public String home(HttpServletRequest request) {
        return "Hello World " + request.getSession().getId();
    } 

}
