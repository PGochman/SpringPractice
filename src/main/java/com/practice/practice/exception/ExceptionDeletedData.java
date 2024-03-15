package com.practice.practice.exception;

import org.hibernate.ObjectDeletedException;

import java.io.Serializable;
/**
 * Excepción personalizada para indicar que un dato está eliminado del sistema,
 * o hay un error con su estado de actividad.
 * Esta excepción se lanza cuando se intenta módificar un dato desactivado,
 * o cuando se intenta activar un dato que ya esta activo, o desactivar un
 * dato que ya está inactivo.
 */
public class ExceptionDeletedData extends ObjectDeletedException {
    /**
     * Mensaje con información del error
     */
    private String message;

    /**
     * Constructor con un mensaje personalizado, e información del identificador
     * del dato y la entidad en la que se produce
     * @param message Mensaje con información del error
     * @param identifier Id del dato en el que hay un error
     * @param entityName Entidad en la que se produce el error
     */
    public ExceptionDeletedData(String message, Serializable identifier, String entityName) {
        super(message, identifier, entityName);
        this.message = message;
    }

    /**
     * Obtiene el mensaje con información del error
     * @return mensaje con información del error
     */
    @Override
    public String getMessage() {
        return message;
    }
}
