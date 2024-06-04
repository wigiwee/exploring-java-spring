package com.SpringCore.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("com/SpringCore/demo2/spring.xml");
//        Vehicle obj  = (Vehicle) context.getBean("bike");
//        obj.drive();
//        Tyre t = (Tyre) context.getBean("tyre");
//        System.out.println(t);
        Car car = (Car)context.getBean("car");
        car.drive();        
    }
}
