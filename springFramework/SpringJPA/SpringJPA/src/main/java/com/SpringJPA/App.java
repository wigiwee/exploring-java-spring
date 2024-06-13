package com.SpringJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    public static void main( String[] args ){
    	//implementing JPA using hibernate
		
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
    	EntityManager em = emf.createEntityManager();
    	Student s =  em.find(Student.class, 2); //fetches the data from database
		System.out.println(s);

		em.getTransaction().begin(); //to save the object to db, transaction needs to be started
		em.persist(new Student(4, "John", "new york"));
		em.getTransaction().commit();

    }
}
