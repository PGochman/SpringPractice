package com.practice.practice.dto.response;
/**
 * DTO para representar una respuesta en forma de mensaje.
 * Contiene el campo message que va a tener el mensaje de respuesta.
 * Se utiliza para responder en forma de mensaje.
 */
public class StringResponse {
    /**
     *Mensaje de respuesta
     */
    private String message;

    /**
     * Constructor que instancia el campo de message
     * @param message mensaje de respuesta
     */
    public StringResponse(String message) {
        this.message = message;
    }

    /**
     * Obtiene el mensaje de respuesta
     * @return mensaje de respuesta
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje de respuesta
     * @param message mensaje de respuesta
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
