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
        // System.out.println(student);
        System.out.println(student.hashCode());

        Student student2= context.getBean("obj", Student.class);
        System.out.println(student2.hashCode()); // both objects have same hashCode, // this is referred as singleton scope
                                                // after added @scope("prototype") then the hashCode will not match

        Teacher teacher = context.getBean("teacher", Teacher.class);
        Teacher teacher2 = context.getBean("teacher", Teacher.class);

        System.out.println(teacher.hashCode());   
        System.out.println(teacher2.hashCode()); //hashCode will not match because scope is defined as prototype in xml file
                                                // if scope was singleton then hash code would match
    }
}
