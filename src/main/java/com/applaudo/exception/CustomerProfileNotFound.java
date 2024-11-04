package com.applaudo.exception;

public class CustomerProfileNotFound extends RuntimeException {
    public CustomerProfileNotFound(String message) {
        super(message);
    }
}
