package com.SpringHQL;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
//        
//        for(int i =0 ; i<50; i++) {
//        	Student s = new Student();
//        	s.setId(i);
//        	s.setName("name" + i);
//        	s.setCity("city"+i);
//        	session.save(s);
//        }
//        Query q1 = session.createQuery("from Student where id>25");
//        List <Student> students = q1.list();
//        for(Student s : students){
//        	System.out.println(s);
//        }
        
//        Query q2 = session.createQuery("from Student where id=26");
//        Student student =  (Student) q2.uniqueResult();
//        System.out.println(student);
        
//        Query q3 = session.createQuery("select id,name, city from Student where id=6");
//        Object[] student =  (Object[]) q3.uniqueResult();
//        System.out.println(student[0] + " "+student[1] + " "+student[2] );
//        session.getTransaction().commit();
        
//        int a = 34;
////        Query q4 = session.createQuery("select id,name, city from Student s where s.id>"+a);  //here concatenation is not preferred
//        Query q4 = session.createQuery("select id,name, city from Student s where s.id > :var");  
//        q4.setParameter("var", a);
//        
//        List<Object[]> students = q4.list();
//        for(Object[] student : students) {
//        	System.out.println(student[0] + " "+student[1] + " "+student[2] );
//        }
//        
        //native queries
//        //firing SQL query in hibernate
//        SQLQuery sql = session.createSQLQuery("select * from Student where id>16 ");
//        //in order to get get list of Students all the properties of Student calss must be fetched
//        sql.addEntity(Student.class);   //by adding this line we will get the list of Student otherwise we will get the list of Object class
//        
//        List<Student> students = sql.list(); 
//        for(Student s : students){
//        	System.out.println(s);
//        }
//        
       
        SQLQuery sql = session.createSQLQuery("select id, name from Student where id>16 ");
        sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); // converts output into map format
        List students = sql.list(); 
        for(Object o : students){
        	Map m = (Map) o;
        	System.out.println(m.get("id") + " : " + m.get("name"));
        }
        
        
    }
}
