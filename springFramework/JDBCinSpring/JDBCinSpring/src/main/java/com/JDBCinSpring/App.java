package com.JDBCinSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.entities.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Welcome to Application");
        ApplicationContext context = new ClassPathXmlApplicationContext("com/JDBCinSpring/configuration.xml");
        
        
        //not recommended method
//        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//        String query = "insert into students(id, name, city) value(?, ?, ?)";
//        int result = 		template.update(query, 452, "Aayush", "Varangaon");
//        System.out.println("no. of records inserted: "+result);
        
        StudentDao studentDao =  context.getBean("studentDao", StudentDao.class);
        Student student= new Student();
        student.setId(152);
        student.setName("Alen");
        student.setCity("Hydrabad");
        
        int result = studentDao.insert(student);
        System.out.println("Studets added: " + result);
    }
}
