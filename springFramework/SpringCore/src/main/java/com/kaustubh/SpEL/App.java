package com.kaustubh.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.Expression;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("com/kaustubh/SpEL/configuration.xml");   
            Demo d1 =context.getBean("demo",Demo.class);
            System.out.println(d1);

            //manually  doing Spring Expression 
            SpelExpressionParser temp = new SpelExpressionParser();
            Expression expression = temp.parseExpression("5+56"); // no #{} needed here
            System.out.println(expression.getValue());
    }
}