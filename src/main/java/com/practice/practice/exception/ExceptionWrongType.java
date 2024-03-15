package com.practice.practice.exception;
/**
 * Clase que representa el manejo de información de un error al hacer
 * una petición con un tipo erróneo en algún campo necesario.
 * Se utiliza para manejar las excepciones de la clase HttpMessageNotReadableException.
 */
public class ExceptionWrongType {
    /**
     * Campo en el que se produce el error
     */
    private String field;
    /**
     * Detalle del error
     */
    private String detail;
    /**
     * Mensaje personalizado de error
     */
    private String message;
    /**
     * Tipo necesario del campo en el que se produce el error
     */
    private String type;

    /**
     * Constructor que instancia todos los campos con la información necesaria
     * @param detail detalle de la excepción lanzada
     */
    public ExceptionWrongType(String detail){
        this.detail = detail;
        this.field = detail.split("\\[\"")[1].split("\"]")[0];
        this.type = detail.split("`")[1].split("\\.")[2];
        this.message = "Error en la request: campo '" + field + "' de tipo incorrecto, debe ser de tipo '" + type + "'";
    }

    /**
     * Obtiene el detalle del error
     * @return detalle del error
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Obtiene el mensaje con información del error
     * @return mensaje con información del error
     */
    public String getMessage() {
        return message;
    }

    /**
     * Convierte los datos del error a un string con toda la información necesaria
     * @return Mensaje con toda la información del error
     */
    @Override
    public String toString(){
        return "Error en la request: campo " + field + " de tipo incorrecto, debe ser un entero positivo" + "\nMás detalle: " + detail;
    }
}
