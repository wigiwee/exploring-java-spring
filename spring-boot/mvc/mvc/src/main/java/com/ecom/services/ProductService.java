package com.ecom.services;

import java.util.List;

import com.ecom.entities.Category;
import com.ecom.entities.Product;
import com.ecom.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import com.ecom.repositories.ProductRepository;

import jakarta.transaction.Transactional;

// import in.repositories.CategoryRepository;

@Service
public class ProductService {

    // @Autowired   //implicitly autowiring 
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    //constructor injection enabled by default
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    
    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    
    public Product findById(int id){
        return productRepository.findById(id).get();
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }


    //implementing transaction 
    //method to save  a category and product

    @Transactional
    public void transactCategoryWithProduct(){

        //saving category
        Category category = new Category();
        category.setTitle("garments");
        
        categoryRepository.save(category);


        Product product = new Product();
        product.setTitle("clothes");

        //description will throw an exception   
        //after this statement throws an exception the category created will be automatically deleted
        //all the changes in this method will be roll backed
        product.setDescription("a 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d thingsa 3d printer to print 3d things");
        

        product.setPrice(1255);
        
        productRepository.save(product);
    }

}
