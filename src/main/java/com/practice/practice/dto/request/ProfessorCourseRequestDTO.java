package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProfessorCourseRequestDTO {
    private Long id;
    @NotNull(message = "El id del profesor no puede ser nulo, enviar un valor")
    @Positive(message = "El id del profesor debe ser un numero positivo")
    private Long professorId;
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    public ProfessorCourseRequestDTO(Long id, Long professorId, Long courseId) {
        this.id = id;
        this.professorId = professorId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
