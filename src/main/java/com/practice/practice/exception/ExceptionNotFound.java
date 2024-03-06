package com.practice.practice.exception;

import org.springframework.data.crossstore.ChangeSetPersister;


public class ExceptionNotFound extends ChangeSetPersister.NotFoundException {
    private String message;
    public ExceptionNotFound(String model, String parameter, String variable){
        super();
        this.message = "No se encontró un " + model + " con " + parameter + " " + variable;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
