package com.sytoss.edu2021.services;

import lombok.Getter;

@Getter
public class ErrorInAnotherService extends RuntimeException{

    private int statusCode;
    private String exceptionClass;

    public ErrorInAnotherService(String exceptionClass,int statusCode,String message){
        super(message);
        this.exceptionClass = exceptionClass;
        this.statusCode = statusCode;
    }

}
