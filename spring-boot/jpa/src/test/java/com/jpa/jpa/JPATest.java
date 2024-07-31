package com.jpa.jpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.jpa.entities.Category;
import com.jpa.jpa.services.CategoryService;

@SpringBootTest
public class JPATest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void CriteriaTest(){

        List<Category> categories = categoryService.getAllCategories();
        categories.forEach(System.out::println);
    }
}   
