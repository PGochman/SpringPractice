package com.practice.practice.exception;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
/**
 * Clase que representa el manejo de información de un error de argumentos
 * no válidos en las peticiones.
 * Se utiliza para manejar las excepciones de la clase MethodArgumentNotValidException.
 */
public class ExceptionWrongMethod {
    /**
     * Mensaje con información del error
     */
    private String message;
    /**
     * Información más detallada del error
     */
    private String detail;

    /**
     * Constructor que instancia el mensaje y el detalle del error
     * @param ex Excepción a manejar
     */
    public ExceptionWrongMethod(MethodArgumentNotValidException ex) {
        this.detail = ex.getMessage();
        StringBuilder message = new StringBuilder();
        for(ObjectError er : ex.getAllErrors()){
            message.append(er.getDefaultMessage()).append(" - ");
        }
        this.message = message.toString();
    }

    /**
     * Obtiene el mensaje con información del error
     * @return mensaje con información del error
     */
    public String getMessage() {
        return message;
    }

    /**
     * Obtiene el detalle del error
     * @return mensaje con información más detallada del error
     */
    public String getDetail() {
        return detail;
    }
}
