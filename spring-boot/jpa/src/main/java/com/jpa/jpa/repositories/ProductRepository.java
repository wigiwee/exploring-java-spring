package com.jpa.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.jpa.entities.Category;
import com.jpa.jpa.entities.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //naming convention of predefined methods of JpaRepository

    //predefined methods
    List<Product> findByPrice(int price);
    
    List<Product> findByCategory(Category category);

    //no need to write the method 
    List<Product> findByTitle(String title);

    boolean existsByTitle(String title);    //return true if product with title exists

    //return the count 
    int countByPrice(int price);
    
    List<Product> findByLive(boolean live);

    // ----------------------------------------------------------
    //custom method using native query or JPQL/HQL

    @Query("select p from Product p ")
    List<Product> getMyCustomQueryProduct();

    //native query
    @Query(nativeQuery = true, value = "select * from jpa_products")
    List<Product> getMyCustomNativeQueryProduct();

    //with parameters

    @Query("select p from Product p Where p.title =: title and p.price =: price")
    List<Product> getProductByTitle(@Param("title") String title, 
        @Param("price") double price);

}
