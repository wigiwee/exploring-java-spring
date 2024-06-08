package com.SpringHibernate;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ){

    	
    	Laptop laptop =new Laptop(13, "Dell");
    	Laptop laptop2 =new  Laptop(15, "Lenovo");
    	Laptop laptop3 = new Laptop(187, "HP");
    	
    	Student student = new Student(145, new StudentName("jayesh", "suresh", "Patil") , "anygaon", new ArrayList<Laptop>() ); //here new object of laptop will not be created but the student will be assigned to existing laptop entry in Laptop table
    	laptop.getStudent().add(student);
    	student.getLaptop().add(laptop2);
    	student.getLaptop().add(laptop);
    	
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    	
    	//wrong way
    	//ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    	
    	SessionFactory sf = conf.buildSessionFactory(sr);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	//saves student in database
    	session.save(laptop);
    	session.save(laptop2);
    	session.save(laptop3);
    	
    	session.save(student);
    	
//    	
    	//getting a student object from database
    	//Student student2 = session.get(Student.class,112 );
    	//System.out.println(student2);		
    	
    	tx.commit();
    	
    }
}
