package com.jpa.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpa.entities.Product;
import com.jpa.jpa.repositories.CategoryRepository;
import com.jpa.jpa.repositories.ProductRepository;

// import in.repositories.CategoryRepository;

@Service
public class ProductService {

    // @Autowired   //implicitly autowiring 
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //constructor injection enabled by default
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    
    public Product findById(int id){
        return productRepository.findById(id).get();
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

}
