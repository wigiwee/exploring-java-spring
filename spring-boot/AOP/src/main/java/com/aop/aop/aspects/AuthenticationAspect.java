package com.aop.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
@Aspect
public class AuthenticationAspect {

    @Around("execution(* com.aop.aop.services.LoginService.login(String, String))")
    public void checkUser(ProceedingJoinPoint joinPoint) throws Throwable {
        String username = (String) joinPoint.getArgs()[0];
        String password = (String) joinPoint.getArgs()[1];

        if(username.equals("admin") && password.equals("admin")) {
            System.out.println("user authenticated");
            joinPoint.proceed();    //method will proceed
        }else {
            System.out.println("User is not logged in");
            throw new LoginException("User is not logged in");
        }

    }

}
