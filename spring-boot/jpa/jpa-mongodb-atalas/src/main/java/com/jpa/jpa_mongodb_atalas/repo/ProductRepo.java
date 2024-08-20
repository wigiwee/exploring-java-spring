package com.jpa.jpa_mongodb_atalas.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.jpa.jpa_mongodb_atalas.entity.Product;


@Component
public interface ProductRepo extends MongoRepository<Product, Integer> {
}
