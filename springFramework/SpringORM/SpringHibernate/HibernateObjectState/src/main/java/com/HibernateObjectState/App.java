package com.HibernateObjectState;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ){
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        session.beginTransaction();
        
        Student s = new Student();
        s.setId(96);
        s.setName("Aayush");
        s.setCity("New York");
        
        session.save(s); //object saved in database
        
        s.setCity("Pune"); // value changed after saving the object
        //because the object is in persistent state the value in database will be modified
        
        //changing object state from persistent state to removed state
        session.remove(s); //deletes the row from the database/ fires delete query
       
        
        //fetching data
        
        //get gives the object
        //returns null when the obj is not found
        Student s1  = session.get(Student.class, 201); //fetches the object when the get method is called
        System.out.println(s1);
        
        //load gives a proxy object
        //the object will the fetched when the obj is accessed
        //throws exception when the obj is not found
        Student s2 = session.load(Student.class, 2); //fetches the object when the object is accessed
        System.out.println(s2);
        
        
        session.getTransaction().commit();
        
        //changing object state from persistent state to detached state
        session.detach(s);
        s.setCity("Patna"); //value will not be updated in database because the object is in detached state
        
    }
}
