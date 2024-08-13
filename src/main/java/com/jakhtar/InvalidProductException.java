package com.jakhtar;

public class InvalidProductException extends RuntimeException {
    
    public InvalidProductException(String msg) {
        super(msg);
    }
}
