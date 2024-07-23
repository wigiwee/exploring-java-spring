package com.aop.aop.services;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public void printAllProducts() {
        System.out.println("All products");
        System.out.println("product 1");
        System.out.println("product 2");
        System.out.println("product 3");
        System.out.println("product 4");
    }
}
