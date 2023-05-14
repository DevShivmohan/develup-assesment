package com.assesment.develup.global.exception;

import lombok.Data;

@Data
public class CustomException extends Exception{
    private int statusCode;
    private String errorMessage;
    public CustomException(int statusCode,String errorMessage){
        super(errorMessage);
        this.statusCode=statusCode;
        this.errorMessage=errorMessage;
    }
}
