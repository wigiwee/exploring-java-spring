package com.ecom.services;

import java.util.List;

import com.ecom.entities.Category;
import com.ecom.repositories.CategoryRepository;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class CategoryService {

    //implementing Category service with Criterial API

    @Autowired
    private CategoryRepository repository;

    private EntityManager entityManager;


    //enabling constructor injection
    public CategoryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Category> getAll(){
        return repository.findAll();
    }
    public List<Category> getAllCategories(){
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        //represents our sql query
        CriteriaQuery<Category> criteriaQuery = criteriaBuilder.createQuery(Category.class);
        //select clause
        //select root entity
        //optional filtering

        Root<Category> root = criteriaQuery.from(Category.class);

        
        //making a predicate for where method of criteria query;
        Predicate predicate1 = criteriaBuilder.equal(root.get("title"), "trending");
        Predicate predicate2 = criteriaBuilder.equal(root.get("id"), "2");

        Predicate orPredicate = criteriaBuilder.or(predicate1, predicate2);

        Order order =criteriaBuilder.desc(root.get("title"));
        
        criteriaQuery
                .select(root)
                // .where(predicate1, predicate2)        //takes predicate // by default will take and condition
                .where(orPredicate)                     //for or operation use this
                .orderBy(order)     //order by 
                .groupBy(root.get("title")) 
        ;

        List<Category> resultList = entityManager.createQuery(criteriaQuery).getResultList();

        return resultList;
    }
}
