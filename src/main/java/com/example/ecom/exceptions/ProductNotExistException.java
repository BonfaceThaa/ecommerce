package com.example.ecom.exceptions;

public class ProductNotExistException extends Throwable {
    public ProductNotExistException(String msg) {
        super(msg);
    }
}
