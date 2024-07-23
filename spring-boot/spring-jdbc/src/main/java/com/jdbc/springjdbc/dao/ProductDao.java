package com.jdbc.springjdbc.dao;

import com.jdbc.springjdbc.dao.Model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getAll();

    Product getById(int id);

    Product create(Product product);

    Product update(int productId, Product product);

    Product delete(int id);

    List<Product> search(String keyword);

}
