package com.aop.aop.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public void login(String username, String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println(("Login successful"));

    }

    public void logout(){
        System.out.println("Logging out user");

    }
}
