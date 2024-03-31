package com.example.virus.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ApiResponse {
    private  String status;
    private final Date apiTimeStamp;
    private String path;
    private Object data;
    private Object error;

    public ApiResponse(){
        this.apiTimeStamp = new Date();
    }
}
