package com.photos.oauth.photos_auth_example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotosController {

    @GetMapping("/photos")
    public String photoString() {
        return "photos";
    }

    @GetMapping("/")
    public String home () {
        return "index";
    }
    
}
