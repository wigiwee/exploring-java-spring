package com.jpa.jpa_mongodb_atalas.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "products")
public class Product {

    @Id
    private int id;

    private String name;

    private int price;

    private int quantity;
}
