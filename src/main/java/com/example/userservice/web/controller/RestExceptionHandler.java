package com.example.userservice.web.controller;

import com.example.userservice.model.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException e) {
        return "Resource not found.";
    }

    @ExceptionHandler
    public String handleException(Exception e) {
        return "Something happened.";
    }

}
