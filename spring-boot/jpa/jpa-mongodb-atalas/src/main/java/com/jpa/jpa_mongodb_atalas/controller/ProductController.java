package com.jpa.jpa_mongodb_atalas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa_mongodb_atalas.entity.Product;
import com.jpa.jpa_mongodb_atalas.service.ProductService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController("/api/products")
public class ProductController {    

    private final ProductService productService ;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
 
    @GetMapping
    public List<Product> getall() {
        return productService.getAllProducts();
    }
    
    @PostMapping
    public Product create (@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Product putMethodName(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable int id){
        return productService.delete(id);
    }
}
