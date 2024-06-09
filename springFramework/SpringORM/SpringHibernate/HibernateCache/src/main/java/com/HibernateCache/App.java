package com.HibernateCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ){
        Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class);
        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(sr);
        
        //creating new session
        
        Session session = sf.openSession();
        session.beginTransaction();
        
        //session.save(new Student(33, "Aayush", "Varangaon"));
        //session.save(new Student(32, "Kaustubh", "Loin"));
        
        
        //even though the object is requested twice, the query will be fired only once
        //because the output is stored in cache
        session.get(Student.class, 32);
        session.get(Student.class, 32);
        
        session.getTransaction().commit();
        session.close();
        
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        //in this case query will be fired because the session is different
        //to optimize this second level cache is used
        session2.get(Student.class, 32);
        
        session2.getTransaction().commit();
        session2.close();
    }
}
