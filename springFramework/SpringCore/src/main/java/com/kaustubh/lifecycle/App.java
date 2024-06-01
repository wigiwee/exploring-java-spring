package com.kaustubh;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
//        Samosa samosa1 = (Samosa) context.getBean("s1");
//        System.out.println(samosa1);
//        //registering shutdown hook
        context.registerShutdownHook();  
//        
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        
//        Pepsi pepsi = (Pepsi) context.getBean("pepsi");
//        System.out.println(pepsi);
        Fafda fafda = (Fafda) context.getBean("fafda");
        System.out.println(fafda);
    }
}
