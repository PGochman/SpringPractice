package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO para representar la solicitud de información de un profesor y curso.
 * Contiene los campos necesarios para relacionar un curso y un profesor.
 * Se utiliza para los cuerpos de las solicitudes referentes a la relacion
 * de cursos y profesores.
 */
public class ProfessorCourseRequestDTO {
    /**
     * ID del profesor a relacionar.
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del profesor no puede ser nulo, enviar un valor")
    @Positive(message = "El id del profesor debe ser un numero positivo")
    private Long professorId;
    /**
     * ID del curso a relacionar.
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    /**
     * Constructor que insancia el objeto con professorId y courseId
     * @param professorId Id del profesor
     * @param courseId Id del curso
     */
    public ProfessorCourseRequestDTO(Long professorId, Long courseId) {
        this.professorId = professorId;
        this.courseId = courseId;
    }

    /**
     * Obtiene el id del profesor
     * @return id del profesor
     */
    public Long getProfessorId() {
        return professorId;
    }

    /**
     * Establece el id del profesor
     * @param professorId id del profesor
     */
    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    /**
     * Obtien el id del curso
     * @return id del curso
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * Establece el id del curso
     * @param courseId id del curso
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
