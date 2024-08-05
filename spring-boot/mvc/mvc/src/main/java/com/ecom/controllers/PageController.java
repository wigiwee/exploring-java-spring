package com.ecom.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entities.Category;
import com.ecom.exceptions.ResourceNotFoundException;

// @RestController // @ResponseBody + @Controller
@Controller
public class PageController {
    
    @RequestMapping(path = "/home", method=RequestMethod.GET)
    @ResponseBody
    public String getHome() {
        if(true){
            throw new ResourceNotFoundException("home controller exception");
        }
        
        return "hello from home";
    }

    @GetMapping("/courses")
    @ResponseBody   //returns json obj
    public Map<String, String> getFees(){
        Map<String, String> course = new HashMap<>();
        course.put("sping-boot", "233");
        course.put("alksdjf", "33");
        course.put("aldjf", "333");
        return course;

    }

    //going to create and return a category
    @RequestMapping(path = "/category", method=RequestMethod.GET)
    @ResponseBody
    public Category category() {
        Category category = new Category();
        category.setId(0);
        category.setTitle("test");
        return category;
    }
    
    
}
