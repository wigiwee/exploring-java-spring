package com.HibernateCache;

import org.hibernate.Query;
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
        Query q1 = session.createQuery("from Student where id=32");
        q1.setCacheable(true);
        
        Student a = (Student) q1.uniqueResult();        
        System.out.println(a);  //this time query will be fired
        
        Student b = (Student) q1.uniqueResult();        
        System.out.println(b);  //this time query will be fired
        
        
        //session.save(new Student(33, "Aayush", "Varangaon"));
        //session.save(new Student(32, "Kaustubh", "Loin"));
        
        
        //even though the object is requested twice, the query will be fired only once
        //because the output is stored in cache
//        session.get(Student.class, 32);
//        session.get(Student.class, 32);
        
        session.getTransaction().commit();
        session.close();
        
        
        //creating second session
        Session session2 = sf.openSession();
        session2.beginTransaction();
        
        Query q2 = session2.createQuery("from Student where id=32");
        q2.setCacheable(true);
        
        Student c = (Student) q2.uniqueResult();        
        System.out.println(c);  //this time query will be fired

        
        //in this case query will be fired because the session is different
        //to optimize this second level cache is used
//        session2.get(Student.class, 32);
        
        session2.getTransaction().commit();
        session2.close();
    }
}
