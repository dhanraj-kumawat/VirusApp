package com.example.virus.exception;

import lombok.Getter;

@Getter
public class PatientIdNotFoundException extends RuntimeException{
    private String exceptionMsg;
    public PatientIdNotFoundException(){}
    public PatientIdNotFoundException(String exceptionMsg){
        this.exceptionMsg = exceptionMsg;
    }
}
