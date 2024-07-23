package com.week1.lifecycle;


import com.week1.lifecycle.beans.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
//        Employee employee = context.getBean(Employee.class);
//        employee.work();


    }
}
