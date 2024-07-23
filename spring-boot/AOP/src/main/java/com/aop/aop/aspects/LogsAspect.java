package com.aop.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogsAspect {

    //advices

//    @Before("execution(* com.aop.aop.services.LoginService.login())")
    @Before("execution(* com.aop.aop.services.*.*())")                 // while dealing with patters parameters pattern must match
    public void maintainLogs(){
        System.out.println("LogsAspect maintainLogs");
        System.out.println("maintaining logs");
    }

    @After("execution(* com.aop.aop.services.*.*())")
    public void afterLogs(){
        System.out.println("LogsAspect afterLogs");
        System.out.println("after logging");
    }

}
