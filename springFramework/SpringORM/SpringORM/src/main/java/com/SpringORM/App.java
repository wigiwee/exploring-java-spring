package com.SpringORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ){
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringORM/Config.xml");
    	
    	StudentDao dao = context.getBean("StudentDao", StudentDao.class);
    	
    	Student student = new Student(334, "Harry Potter" , "London");
    	
    	dao.save(student);
    }
}
