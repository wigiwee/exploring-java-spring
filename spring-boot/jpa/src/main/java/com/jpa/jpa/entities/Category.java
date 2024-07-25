package com.jpa.jpa.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
public class Category {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    //single product belongs to single category
    // @OneToOne(mappedBy = "category")    //category table won't create a extra unnecessary column
    // private Product product;

    //multiple products belongs to single category
    @OneToMany(mappedBy = "category")   //won't create a extra table 
    private List<Product> products;


    
}
