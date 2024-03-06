package com.practice.practice.exception;

public class ExceptionWrongType {
    private String field;
    private String detail;
    private String message;
    private String type;

    public ExceptionWrongType(String detail){
        this.detail = detail;
        this.field = detail.split("\\[\"")[1].split("\"]")[0];
        this.type = detail.split("`")[1].split("\\.")[2];
        this.message = "Error en la request: campo '" + field + "' de tipo incorrecto, debe ser de tipo '" + type + "'";
    }

    public String getDetail() {
        return detail;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString(){
        return "Error en la request: campo " + field + " de tipo incorrecto, debe ser un entero positivo" + "\nMás detalle: " + detail;
    }
}
