package com.jpa.jpa;

import com.jpa.jpa.entities.Category;
import com.jpa.jpa.entities.Product;
import com.jpa.jpa.repositories.CategoryRepository;
import com.jpa.jpa.repositories.ProductRepository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("Starting the test");
	}

	@Autowired
	private ProductRepository productRepository;


	@Test
	void TestProductRepository(){
		System.out.println("Hello");
		productRepository.findAll().forEach(System.out::println);
	}

	@Test
	void TestProductRepository2(){
		productRepository.findByTitle("Samsung S23 ultra").forEach(System.out::println);
	}

	@Test
	void testFindByTitleContaining(){
		productRepository.findByTitleContaining("samsung").forEach(System.out::println);

	}
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void createCategory(){

		Category category = new Category();
		category.setTitle("Phone");
		category.setId(1);
		Category category2 = new Category();
		category2.setTitle("trending");
		category2.setId(2);
		categoryRepository.save(category);
		categoryRepository.save(category2);
	}

	@Test
	void updateProductTest(){
		productRepository.findById(4).ifPresentOrElse(product ->{
			Category category = categoryRepository.findById(2).get();
			product.setCategory(category);
			productRepository.save(product);
		}, () ->{
			System.out.println("Product not found");
		});
	}

	@Test
	public void joinQueryTest() {
		//joining two entities 
		List<Product> phone = productRepository.getProductByCategoryTitle("Trending");
		System.out.println(phone);

	}
}
