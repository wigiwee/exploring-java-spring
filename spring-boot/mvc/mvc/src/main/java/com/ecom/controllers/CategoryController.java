package com.ecom.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.entities.Category;
import com.ecom.services.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    // @RequestMapping("/", method=RequestMethod.GET)
    // public String requestMethodName(@RequestParam String param) {
    //     return new String();
    // }
    

    //here pageNumber and pageSize are query parameters embedded in the url
    @RequestMapping(path = "/getCat", method=RequestMethod.GET)
    public String getTitle(@RequestParam(value = "pageSize", required = false, defaultValue = "10" ) int pageSize,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "8") int pageNumber) {    
        System.out.println("page Size: " + pageSize);
        System.out.println("page Number: " + pageNumber);
        return new String();
    }
    
    //receiving from request  body in json form
    @RequestMapping(path = "/addCat", method=RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        System.out.println(category.getId());
        System.out.println(category.getTitle());
        return category;
    }
    
    @PostMapping("/image")
    public String imageUpload (@RequestBody MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return "file Uploaded " + file.getOriginalFilename();
    }
    
    
    
}
