package com.practice.practice.exception;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class ExceptionWrongMethod {
    private String message;
    private String detail;

    public ExceptionWrongMethod(MethodArgumentNotValidException ex) {
        this.detail = ex.getMessage();
        StringBuilder message = new StringBuilder();
        for(ObjectError er : ex.getAllErrors()){
            message.append(er.getDefaultMessage()).append(" - ");
        }
        this.message = message.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
