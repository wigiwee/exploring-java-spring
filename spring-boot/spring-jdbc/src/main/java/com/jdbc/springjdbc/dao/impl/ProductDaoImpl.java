package com.jdbc.springjdbc.dao.impl;

import com.jdbc.springjdbc.dao.Model.Product;
import com.jdbc.springjdbc.dao.ProductDao;

import java.util.List;

public class ProductImpl implements ProductDao {
    

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(int productId, Product product) {
        return null;
    }

    @Override
    public Product delete(int id) {
        return null;
    }

    @Override
    public List<Product> search(String keyword) {
        return List.of();
    }
}
