package com.practice.practice.dto.request;

import javax.validation.constraints.*;

public class GradeRequestDTO {
    private Long id;
    @NotNull(message = "Se debe ingresar una nota de la calificacion")
    @Min(value = 0, message = "El valor mínimo de la nota es 0")
    @Max(value = 10, message = "El valor máximo de la nota es 10")
    private Float grade;
    @NotNull(message = "Se debe ingresar el tipo de evaluación")
    private String evaluationType;
    @NotNull(message = "El id del estudiante no puede ser nulo, enviar un valor")
    @Positive(message = "El id del estudiante debe ser un numero positivo")
    private Long studentId;
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;

    private Boolean isActive;

    public GradeRequestDTO() {
    }

    public GradeRequestDTO(Long id, Float grade, String evaluationType, Long studentId, Long courseId) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.studentId = studentId;
        this.courseId = courseId;
        this.isActive = true;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
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
