package com.aop.aop;

import com.aop.aop.services.LoginService;
import com.aop.aop.services.ProductService;
import com.aop.aop.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);
        LoginService service = context.getBean(LoginService.class);
        service.login("admin" , "admin");
        service.logout();
        System.out.println("-------------------------------");
        ProductService service1 = context.getBean(ProductService.class);
        service1.printAllProducts();
        System.out.println("-------------------------------");
        UserService service2 = context.getBean(UserService.class);
        service2.createUser("Lankesh");
    }

}
