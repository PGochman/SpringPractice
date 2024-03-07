package com.practice.practice.exception;

public class ExceptionReturn {
    private String message;

    public ExceptionReturn(Exception ex) {
        this.message = ex.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
