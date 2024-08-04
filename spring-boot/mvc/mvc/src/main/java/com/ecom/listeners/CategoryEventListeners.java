package com.ecom.listeners;

import com.ecom.entities.Category;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;


public class CategoryEventListeners {

    //this method will be executed before saving the object
    @PrePersist
    public void beforeSave(Category category){
        System.out.println("before persist");
//        System.out.println(category);
    }

    @PostPersist
    public void afterSave(Category category){
        System.out.println("after persist");
    }

    //event listening events like @PrePersist and @PostPersist
    // @PostRemove
    // @PreRemove
    // @PreUpdate
    // @PostUpdate

}
