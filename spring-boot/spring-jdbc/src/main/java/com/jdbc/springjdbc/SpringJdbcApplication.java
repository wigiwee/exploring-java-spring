package com.jdbc.springjdbc;

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
        product.setId(4);
        product.setTitle("Mango");
        product.setDescription("yellow mango");
        product.setPrice(120);

        ProductDao productDao = context.getBean(ProductDao.class);
//        Product product1 = productDao.create(product);
//        System.out.println(product1);
        System.out.println(productDao.getAll());
        System.out.println(productDao.getById(3));
    }

}
