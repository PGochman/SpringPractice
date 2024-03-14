package com.practice.practice.dto.response;

import com.practice.practice.exception.ExceptionReturn;

import java.util.List;

/**
 * DTO para representar la respuesta que se va a dar al cliente.
 * Contiene el campo data que va a tener la información de la respuesta.
 * Se utiliza para responder las solicitudes HTTP.
 */
public class ReturnResponse {
    /**
     * Información de la respuesta de la respuesta.
     */
    private Object data;

    /**
     * Constructor para respuestas con información de errores
     * @param ex Excepción con información del error
     */
    public ReturnResponse(ExceptionReturn ex) {
        this.data = ex;
    }

    /**
     * Constructor para respuestas con información del curso
     * @param data CourseResponse con información del curso
     */
    public ReturnResponse(CourseResponseDTO data) {
        this.data = data;
    }
    /**
     * Constructor para respuestas con información de la calificación
     * @param data GradeResponse con información de la calificación
     */
    public ReturnResponse(GradeResponseDTO data) {
        this.data = data;
    }
    /**
     * Constructor para respuestas con información del profesor
     * @param data ProfessorResponse con información del profesor
     */
    public ReturnResponse(ProfessorResponseDTO data) {
        this.data = data;
    }
    /**
     * Constructor para respuestas con un mensaje
     * @param data mensaje para la respuesta
     */
    public ReturnResponse(StringResponse data) {
        this.data = data;
    }
    /**
     * Constructor para respuestas con información del estudiante
     * @param data StudentResponse con información del estudiante
     */
    public ReturnResponse(StudentResponseDTO data) {
        this.data = data;
    }
    /**
     * Constructor para respuestas con información de listas
     * @param list lista con la información a devolver
     */
    public ReturnResponse(List<?> list){
        this.data = list;
    }

    /**
     * Obtiene la información de la respuesta
     * @return información de la respuesta
     */
    public Object getData() {
        return data;
    }

}
