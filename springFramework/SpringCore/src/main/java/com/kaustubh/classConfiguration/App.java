package com.kaustubh.classConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Student student = context.getBean("getStudent",Student.class);
        student.study();

        // context.close(); // needs context to be ClassPathXMLApplicationContext
    }
}
