package com.practice.practice.dto.request;

import javax.validation.constraints.*;
/**
 * DTO para representar la solicitud de información de una relación entre estudiante y curso.
 * Contiene los campos necesarios para relacionar un curso y un estudiante.
 * Se utiliza para los cuerpos de las solicitudes referentes a la relacion entre un estudiante y un curso.
 */
public class StudentCourseRequestDTO {
    /**
     * Id del estudiante
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del estudiante no puede ser nulo, enviar un valor")
    @Positive(message = "El id del estudiante debe ser un numero positivo")
    private Long studentId;
    /**
     * Id del curso
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    /**
     * Constructor por defecto
     */
    public StudentCourseRequestDTO() {
    }

    /**
     * Constructor que instancia los campos de studentId y courseId
     * @param studentId id del estudiante
     * @param courseId id del curso
     */
    public StudentCourseRequestDTO(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    /**
     * Obtiene el id del estudiante
     * @return id del estudiante
     */
    public Long getStudentId() {
        return studentId;
    }

    /**
     * Establece el id del estudiante
     * @param studentId id del estudiante
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    /**
     * Obtiene el id del curso
     * @return id del curso
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * Establece el id del curso.
     * @param courseId id del curso
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
