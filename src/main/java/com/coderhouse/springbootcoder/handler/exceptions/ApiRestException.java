package com.coderhouse.springbootcoder.handler.exceptions;

public class ApiRestException extends Exception {
    public ApiRestException(final String message) {
        super(message);
    }
}
