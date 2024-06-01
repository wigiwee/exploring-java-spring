package com.kaustubh.stereotypeAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("com/kaustubh/stereotypeAnnotation/stereoConfig.xml");
        // Student student = context.getBean("student",Student.class); //will throw 
        //error because bean name is explicitly defined as obj, if name not defined explicitly then default name "student" will be used
        Student student = context.getBean("obj",Student.class);
        System.out.println(student);
        
    }
}
