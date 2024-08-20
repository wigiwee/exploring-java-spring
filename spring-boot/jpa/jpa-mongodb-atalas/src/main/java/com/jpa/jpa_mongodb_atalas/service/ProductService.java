package com.jpa.jpa_mongodb_atalas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.jpa_mongodb_atalas.entity.Product;
import com.jpa.jpa_mongodb_atalas.repo.ProductRepo;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product addProduct( Product product){
        return productRepo.save(product);
    }

    public Product delete(int id){
        
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
        return product;

    }

    public Product updateProduct(int id, Product newProduct){
        Product oldProduct = productRepo.findById(id).get();
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setQuantity(newProduct.getQuantity());
        productRepo.save(oldProduct);
        return oldProduct;
    }

    public Product getById(int id){
        return productRepo.findById(id).get();
    }
}
