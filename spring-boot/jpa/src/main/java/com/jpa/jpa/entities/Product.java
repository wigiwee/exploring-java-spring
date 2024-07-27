package com.jpa.jpa.entities;

import java.util.Date;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
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

@Data
@Table(name = "jpa_products")
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @ToString        //causing some problem with printing join query returned product obj 
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "product_title", 
            unique = true, 
            nullable = false, 
            length = 200
    )

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(this.id).append(" ");
        stringBuilder.append("description: ").append(this.description).append(" ");
        stringBuilder.append("price: ").append(this.price).append(" ");
        stringBuilder.append("category: ").append(this.category.getTitle());
        
        return stringBuilder.toString();
    }
    private String title;

    @Nullable
    private String description;

    private int price;

    private boolean isLive = false;

    private Date releaseDate;    

    //single product belongs to single category
    // @OneToOne       //will create a column in products table to map category to products ( using foreign key )
    // private Category category;

    //multiple products belongs to single category
    @ManyToOne
    private Category category;
    
}