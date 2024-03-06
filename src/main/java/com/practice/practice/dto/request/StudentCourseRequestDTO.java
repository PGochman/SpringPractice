package com.practice.practice.dto.request;

import javax.validation.constraints.*;

public class StudentCourseRequestDTO {
    private Long id;
    @NotNull(message = "El id del estudiante no puede ser nulo, enviar un valor")
    @Positive(message = "El id del estudiante debe ser un numero positivo")
    private Long studentId;
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    public StudentCourseRequestDTO() {
    }

    public StudentCourseRequestDTO(Long id, Long studentId, Long courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
