package com.week1.lifecycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//using interface methods

//@Component
//public class Employee implements InitializingBean , DisposableBean {
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Employee destroyed");
//        System.out.println("DB connection closed");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initializing Employee");
//        System.out.println("DB connection established");
//    }
//
//    public Employee(){
//        System.out.println("Employee constructor");
//    }
//
//    public void work(){
//        System.out.println("Employee working");
//    }
//}


//using annotation
@Component
public class Employee  {
    @PreDestroy
    public void abc() throws Exception {
        System.out.println("Employee destroyed");
        System.out.println("DB connection closed");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Employee");
        System.out.println("DB connection established");
    }

    public Employee(){
        System.out.println("Employee constructor");
    }

    public void work(){
        System.out.println("Employee working");
    }
}
