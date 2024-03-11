package com.practice.practice.exception;

public class ExceptionUnavailableConnection extends RuntimeException{
    private String message;

    public ExceptionUnavailableConnection(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
