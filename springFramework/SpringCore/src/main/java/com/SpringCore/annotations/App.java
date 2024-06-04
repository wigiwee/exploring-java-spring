package com.SpringCore.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Spring core annotations 
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	Samsung s7 = factory.getBean(Samsung.class);
//    	Samsung s7 = (Samsung) factory.getBean("mySamsung");
    	s7.config();
    }
}
 