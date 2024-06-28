package com.demo.MVCdemo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ToString
@Entity
public class Product {

    @Id
    @Column(name ="prodId")
    private int prodId;
    @Column(name= "prodName")
    private String prodName;
    @Column(name = "prodPrice")
    private int prodPrice;
}
