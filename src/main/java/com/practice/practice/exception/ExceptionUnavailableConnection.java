package com.practice.practice.exception;
/**
 * Excepción personalizada para indicar un problema de relación entre entidades.
 * Esta excepción se lanza cuando se intenta relacionar dos entidades y ya están
 * relacionadas, o alguno de los dos datos se encuentra inactivo.
 */
public class ExceptionUnavailableConnection extends RuntimeException{
    /**
     * Mensaje con información del error
     */
    private String message;

    /**
     * Constructor que instancia el mensaje con información específica del error
     * @param message mensaje con información del error
     */
    public ExceptionUnavailableConnection(String message) {
        super(message);
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
