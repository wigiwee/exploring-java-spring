package com.aop.aop.services;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void createUser(String name){
        System.out.println("User created");
        System.out.println("User saved");
    }
}
