package com.example.demo.services.exceptions;

public class ResourceBookSoldOutException extends RuntimeException {

    public ResourceBookSoldOutException() {
        super("This book is sold out");
    }
}
