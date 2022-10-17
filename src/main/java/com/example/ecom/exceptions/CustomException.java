package com.example.ecom.exceptions;

public class CustomException extends IllegalArgumentException{
    
    public CustomException(String msg) {
        super(msg); 
    }
}
