package com.practice.practice.exception;

import javax.servlet.http.HttpServletRequest;

public class ExceptionWrongRoute {
    private String message;
    private String detail;
    private String path;
    private String method;

    public ExceptionWrongRoute(String path, Exception ex) {
        this.detail = ex.getMessage();
        this.path = path;
        this.method = detail.split("'")[1];
        this.message = "No existe una petición de tipo " + method + " en la ruta " + path;

    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }
}
