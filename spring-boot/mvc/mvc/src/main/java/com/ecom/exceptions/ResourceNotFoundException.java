package com.ecom.exceptions;


//creating custom exceptions, this is preferred way 
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(){
        super("Resource not found !");
    }
}
