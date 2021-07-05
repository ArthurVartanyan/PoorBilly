package com.poor.billy.exceptions;

public class UserIllegalArgumentException extends RuntimeException{

    public UserIllegalArgumentException() {
        super();
    }

    public UserIllegalArgumentException (String exceptionText) {
        super(exceptionText);
    }
}