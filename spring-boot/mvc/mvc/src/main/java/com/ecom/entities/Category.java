package com.ecom.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.ecom.listeners.CategoryEventListeners;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "jpa_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(CategoryEventListeners.class)
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(
        unique = true
    )
    private String title;

    //single product belongs to single category
    // @OneToOne(mappedBy = "category")    //category table won't create a extra unnecessary column
    // private Product product;

    //multiple products belongs to single category

    @JsonIgnore
    @OneToMany(
        mappedBy = "category",      //won't create a extra table  
        cascade = CascadeType.ALL,  // when a category is deleted the products will be deleted
        fetch = FetchType.EAGER     //when parent will load child will also load,   // in case of LAZY the child will load when it is fetched and not when the parent is loaded
    )
    private List<Product> products;


    
    
}
