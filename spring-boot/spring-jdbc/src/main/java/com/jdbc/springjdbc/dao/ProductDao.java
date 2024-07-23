package com.jdbc.springjdbc.dao;

import java.util.List;

public interface Product {

    List<Product> getAll();

    Product getById(int id);

    Product create(Product product);

    Product update(int productId, Product product);

    Product delete(int id);

    List<Product> search(String keyword);

}
