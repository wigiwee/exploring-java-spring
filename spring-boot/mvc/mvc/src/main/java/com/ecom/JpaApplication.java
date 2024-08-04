package com.ecom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecom.entities.Product;
import com.ecom.services.ProductService;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{
	
    @Autowired
	private ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
		//we cannot access product service here because it is non static property thats why we are implementing CommandLineRunner class

	}

	@Override
	public void run(String... args) throws Exception {

		Product product = new Product();
		product.setTitle("Samsung S23 ultra");
		product.setDescription("flagship phone");
		product.setPrice(1200);

		
		//  productService.create(product);
	}

}
