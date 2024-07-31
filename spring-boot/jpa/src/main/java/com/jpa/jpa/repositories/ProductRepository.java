package com.jpa.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.jpa.entities.Category;
import com.jpa.jpa.entities.Product;
import com.jpa.jpa.entities.ProductWithCategory;

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

    // (like query)
    List<Product> findByTitleContaining(String title);      // executes like query for title 
    
    // findByTitleContains also works and findByTitleLikeIgnoreCase 
    // "%keyword%"
    List<Product> findByTitleLike(String keyword);

    List<Product> findByTitleStartsWith(String keyword);

    List<Product> findByTitleEndsWith(String keyword);
    //return the count  
    int countByPrice(int price);
    
    List<Product> findByIsLive(boolean live);

    // ----------------------------------------------------------
    //custom method using native query or JPQL/HQL

    @Query("select p from Product p ")
    List<Product> getMyCustomQueryProduct();

    //native query
    @Query(nativeQuery = true, value = "select * from jpa_products")
    List<Product> getMyCustomNativeQueryProduct();

    //with parameters

    @Query("select p from Product p Where p.title =:title and p.price =:price")
    List<Product> getProductByTitle(@Param("title") String title, @Param("price") double price);


    //method to join query and fetch the results
    @Query("select p from Product p JOIN p.category where p.category.title =:catTitle ")
    List<Product> getProductByCategoryTitle(@Param("catTitle") String catTitle);


    @Query("select p from Product p where p.title =:prodTitle ")
    List<ProductWithCategory> getProductWithCategories(@Param("prodTitle") String title);
}
