package com.demo.MVCdemo.services;

import com.demo.MVCdemo.models.Product;
import com.demo.MVCdemo.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

//    List<Product> products =new ArrayList<>(Arrays.asList(
//            new Product(101,"iPhone", 323323),
//            new Product(102, "Canon Camera" , 12341),
//            new Product(103, "iPad", 13431)
//    ));

    public List<Product> getProducts(){
//        return products;
        return productRepo.findAll();
    }

    public Product getProductsById( int prodId) {
//        return products.stream()
//                .filter(p -> p.getProdId() == prodId)
//                .findFirst()
//                .orElse(new Product(100, "No item", 0));
        return productRepo.findById(prodId).orElse(new Product());

    }

    public Product addProduct(Product newProduct) {
//        products.add(newProduct);
        return productRepo.save(newProduct);
    }

    public Product updateProduct(Product product){
//        Product product1 = products.stream()
//                .filter(p -> p.getProdId() == product.getProdId())
//                .findFirst()
//                .get();
//
//        product1.setProdPrice(product.getProdPrice());
//        product1.setProdName(product.getProdName());
//
//        return product1;

        return productRepo.save(product);       //used for saving as well as updating

    }

    public void deleteProduct(int prodId) {
//         return products.removeIf(product -> product.getProdId() == prodId);
        productRepo.deleteById(prodId);

    }
}
