package com.jdbc.springjdbc;

import com.jdbc.springjdbc.dao.CategoryDao;
import com.jdbc.springjdbc.dao.Model.Category;
import com.jdbc.springjdbc.dao.Model.Product;
import com.jdbc.springjdbc.dao.ProductDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Product product = new Product();
        product.setId(1);
        product.setTitle("Orange");
        product.setDescription("yellow orange");
        product.setPrice(150);

        Category category = new Category();
        category.setId(1);
        category.setName("food");
        category.setDescription("tasty food");

        product.setCat_id(category.getId());

        CategoryDao categoryDao = context.getBean(CategoryDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);

//        categoryDao.createCategory(category);
//        Product product1 = productDao.create(product);
//        System.out.println(product1);
//        System.out.println(productDao.getAll());
//        System.out.println(productDao.getById(3));
        productDao.getAllProductWithCategory().forEach(System.out::println);

    }

}
