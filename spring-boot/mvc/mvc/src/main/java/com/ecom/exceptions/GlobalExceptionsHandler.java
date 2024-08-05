package com.ecom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecom.entities.ErrorResponse;

@ControllerAdvice           // exceptions will be handled only for controller classes
public class GlobalExceptionsHandler {


    //global level exception handling only for controllers
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlingException(RuntimeException ex){
        
        System.out.println(ex.getMessage());
        // return "Error Occurred"+ ex.getMessage();        //this will send status code 200
        
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error Occurred " + ex.getMessage());
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceException(ResourceNotFoundException exception){
        
        System.out.println(exception.getMessage());
        
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Error Occurred" + exception.getMessage() );
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        errorResponse.setSuccess(false);

        return ResponseEntity
            .status(errorResponse.getStatus())
            .body(errorResponse);
    }


}
