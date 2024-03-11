package com.practice.practice.exception;

import javax.management.InstanceAlreadyExistsException;

public class ExceptionAlreadyExists extends InstanceAlreadyExistsException {
    public ExceptionAlreadyExists(String message){
        super(message);
    }

    public ExceptionAlreadyExists() {
        super("Este dato ya existe, revise la información e intentelo de nuevo");
    }
}
