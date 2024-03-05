package com.mateo.usersms.presentation.advice;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerExceptions {

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(RuntimeException exception){
        System.out.println("manejando perro");
        throw exception;
    }
}
