package com.practice.practice.exception;

import javax.management.InstanceAlreadyExistsException;

public class ExceptionAlreadyExists extends InstanceAlreadyExistsException {
    public ExceptionAlreadyExists(String model){
        super("Este dato ya existe en la tabla de " + model);
    }
}
