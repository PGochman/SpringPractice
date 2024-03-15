package com.practice.practice.exception;
/**
 * Clase que representa la forma en la que se responde con un error.
 * Se utiliza para las respuestas de los métodos HTTP al cliente.
 */
public class ExceptionReturn {
    /**
     * Mensaje con información específica del error
     */
    private String message;

    /**
     * Constructor que instancia el mensaje que se devuelve
     * @param ex Excepción que se quiere devolver
     */
    public ExceptionReturn(Exception ex) {
        this.message = ex.getMessage();
    }

    /**
     * Obtiene el mensaje con información específica del error
     * @return mensaje con información específica del error
     */
    public String getMessage() {
        return message;
    }
}
