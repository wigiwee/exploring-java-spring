package com.mvc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class HomeController {

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "mvc application");

        return "about";
    }
}
