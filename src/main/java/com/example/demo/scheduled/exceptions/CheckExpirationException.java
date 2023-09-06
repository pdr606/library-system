package com.example.demo.scheduled.exceptions;

public class CheckExpirationException extends RuntimeException {

    public CheckExpirationException() {
        super( "Resource not found. Id");
    }
}
