package com.poor.billy.exceptions;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException() {
        super();
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}