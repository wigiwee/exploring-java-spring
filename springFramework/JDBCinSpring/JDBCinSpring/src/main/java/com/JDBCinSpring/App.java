package com.JDBCinSpring;

import java.util.List;

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
        //inserting student
//        student.setId(157);
//        student.setName("Alien");
//        student.setCity("varangaon");
////        
//        int result = studentDao.insert(student);
//        System.out.println("Studets added: " + result);
////        
//        //updating student
//        Student student2 = new Student();
//        student2.setId(125);
//        student2.setCity("new City");
//        student2.setName("Mukessss");
//        int result = studentDao.update(student2);
//        System.out.println("Student updated , row affected:" + result);
//        
//        //delete operation
//        int reuslt =studentDao.delete(452);
//        System.out.println("Deleted: "+ reuslt);
//        
//        
//        //read operation
//        Student student2 = studentDao.getStudent(125); //fetches the student by id from database and maps it to the object
//        System.out.println(student2);
//        
//        //fetching all students in an object list;
        List<Student> allStudents = studentDao.getAllStudents();
        for(Student s: allStudents) {
        	System.out.println(s);
        }
        
        
        
    }
}
