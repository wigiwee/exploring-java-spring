package com.kaustubh.classConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.kaustubh.classConfiguration")
public class Config {


    @Bean // another way of making a bean, bean id is method name //instead of using @Component we can make bean like this //@Component scan not needed for this method means no need to declare base package 
    public Student getStudent(){
        //creating a new student object
        Student student = new Student(getSamosa());
        return student;
    }

    @Bean(name = {"samosa", "tastySamosa", "deliciousSamosa"})  //assigning multiple names to the bean 
    public Samosa getSamosa(){
        return new Samosa();
    }
}
