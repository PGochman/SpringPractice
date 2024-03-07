package com.practice.practice.exception;

import org.hibernate.ObjectDeletedException;

import java.io.Serializable;

public class ExceptionDeletedData extends ObjectDeletedException {
    private String message;

    public ExceptionDeletedData(String message, Serializable identifier, String entityName) {
        super(message, identifier, entityName);
        this.message = message;
    }
}
