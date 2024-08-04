package com.ecom;

import java.util.List;

import com.ecom.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecom.services.CategoryService;
import com.ecom.services.ProductService;

@SpringBootTest
public class JPATest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Test
    public void CriteriaTest(){

        List<Category> categories = categoryService.getAllCategories();
        categories.forEach(System.out::println);
    }
    
    @Test
    public void transactTest(){
        productService.transactCategoryWithProduct();
    }
}   
