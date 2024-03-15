package com.practice.practice.exception;

import javax.servlet.http.HttpServletRequest;
/**
 * Clase que representa el manejo de información de un error al hacer
 * una petición a una ruta no disponible.
 * Se utiliza para manejar las excepciones de la clase HttpRequestMethodNotSupportedException.
 */
public class ExceptionWrongRoute {
    /**
     * Mensaje con información del error
     */
    private String message;
    /**
     * Mensaje con información más detallada del error
     */
    private String detail;
    /**
     * Ruta en la que se produjo el error
     */
    private String path;
    /**
     * Método de la petición del error
     */
    private String method;

    /**
     * Constructor que instancia los campos de message, detail, path y method
     * @param path Ruta en la que se produjo el error
     * @param ex Excepción lanzada
     */
    public ExceptionWrongRoute(String path, Exception ex) {
        this.detail = ex.getMessage();
        this.path = path;
        this.method = detail.split("'")[1];
        this.message = "No existe una petición de tipo " + method + " en la ruta " + path;

    }

    /**
     * Obtiene el mensaje con información del error
     * @return mensaje con información del error
     */
    public String getMessage() {
        return message;
    }
    /**
     * Obtiene el detalle con información más detallada del error
     * @return detalle con información más detallada del error
     */
    public String getDetail() {
        return detail;
    }
    /**
     * Obtiene la ruta en la que se produjo el error
     * @return ruta en la que se produjo el error
     */
    public String getPath() {
        return path;
    }
    /**
     * Obtiene el método que se utilizó en la petición HTTP
     * @return método que se utilizó en la petición HTTP
     */
    public String getMethod() {
        return method;
    }
}
