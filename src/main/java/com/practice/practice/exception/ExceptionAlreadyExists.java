package com.practice.practice.exception;

import javax.management.InstanceAlreadyExistsException;
/**
 * Excepción personalizada para indicar que un dato ya existe en el sistema.
 * Esta excepción se lanza cuando se intenta agregar un dato que ya existe,
 * o cuando se viola una restricción de dato único en la base de datos.
 */
public class ExceptionAlreadyExists extends InstanceAlreadyExistsException {
    /**
     * Constructor con un mensaje personalizado, indicando más datos de la
     * excepción y su razón
     * @param message mensaje con información de la excepción
     */
    public ExceptionAlreadyExists(String message){
        super(message);
    }

    /**
     * Constructor por defecto, enviando un mensaje genérico
     */
    public ExceptionAlreadyExists() {
        super("Este dato ya existe, revise la información e intentelo de nuevo");
    }
}
