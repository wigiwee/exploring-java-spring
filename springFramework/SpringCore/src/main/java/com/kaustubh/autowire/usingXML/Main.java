package com.kaustubh.autowire.usingXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kaustubh/autowire/usingXML/configuration.xml");
		Employee employee =  context.getBean("employee", Employee.class);
		System.out.println(employee);

	}

}
