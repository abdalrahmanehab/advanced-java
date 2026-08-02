package com.pioneers.rest.errors.exceptions;

public class CredentialsException extends RuntimeException {
    public CredentialsException(String description) {
        super(description);
    }
}
