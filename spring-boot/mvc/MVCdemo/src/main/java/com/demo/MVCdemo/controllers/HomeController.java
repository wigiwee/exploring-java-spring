package com.demo.MVCdemo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller()
@RestController()     //return the data as it is, instead of looking for a static resource
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody   //return the data as it is, instead of looking for a static resource
    public String greet(){
        return "Welcome Home";
    }

    @RequestMapping("/about")
    public String about(){
        return "About Page";
    }
}
