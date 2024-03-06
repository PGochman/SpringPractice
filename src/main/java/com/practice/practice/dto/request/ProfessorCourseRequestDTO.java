package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProfessorCourseRequestDTO {
    private Long id;
    @NotNull(message = "El id del profesor no puede ser nulo, enviar un valor")
    @Positive(message = "El id del profesor debe ser un numero positivo")
    private Long profesorId;
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public ProfessorCourseRequestDTO(Long id, Long profesorId, Long courseId) {
        this.id = id;
        this.profesorId = profesorId;
        this.courseId = courseId;
    }
}
