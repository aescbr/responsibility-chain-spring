package com.applaudo.exception;

public class BuyerNotAllowedException extends RuntimeException{
    public BuyerNotAllowedException(String message) {
        super(message);
    }
}
