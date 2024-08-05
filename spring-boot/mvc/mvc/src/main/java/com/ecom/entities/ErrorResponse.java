package com.ecom.entities;

import org.springframework.http.HttpStatus;

import lombok.Data;

//creating a separate class to make ensure standardization
@Data
public class ErrorResponse {

    private String message;
    
    private HttpStatus status;

    private boolean success=false;

}
