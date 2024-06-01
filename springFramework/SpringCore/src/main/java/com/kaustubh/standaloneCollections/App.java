package com.kaustubh.standaloneCollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
         new ClassPathXmlApplicationContext("com/kaustubh/standaloneCollections/aloneConfig.xml");
        Person person =(Person) context.getBean("person");
        System.out.println(person.getFriends().getClass().getName());
        System.out.println(person.getFreeStructure().getClass().getName());
        System.out.println(person);
    }
}