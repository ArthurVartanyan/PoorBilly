package com.poor.billy.exceptions;

import org.springframework.security.core.AuthenticationException;

public class JWTAuthenticationException extends AuthenticationException {

    /**
     * Constructor
     * Call parent's constructor and send message
     *
     * @param message - message / text for error
     */
    public JWTAuthenticationException(String message) {
        super(message);
    }
}