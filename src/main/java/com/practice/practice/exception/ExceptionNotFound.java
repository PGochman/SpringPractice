package com.practice.practice.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
/**
 * Excepción personalizada para indicar que un dato no se encontró en el sistema.
 * Esta excepción se lanza cuando se busca un recurso y no se encuentra.
 */
public class ExceptionNotFound extends ChangeSetPersister.NotFoundException {
    /**
     * Mensaje personalizado con información del error
     */
    private String message;

    /**
     * Constructor para especificar el mensaje de error
     * @param model Entidad en la que no se encontró el dato
     * @param parameter Parámetro por el que se realizó la búsqueda
     * @param variable DatoVariable de parámetro que se utilizó para la búsqueda.
     */
    public ExceptionNotFound(String model, String parameter, String variable){
        super();
        this.message = "No se encontró un " + model + " con " + parameter + " -> " + variable;
    }

    /**
     * Obtiene el mensaje de error
     * @return mensaje con información específica del error
     */
    @Override
    public String getMessage() {
        return message;
    }
}
