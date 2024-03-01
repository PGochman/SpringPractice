package com.practice.practice.dto.request;

import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;

public class CalificacionRequestDTO {
    private Long id;
    private Float grade;
    private String evaluationType;
    private Alumno student;
    private Curso course;

    public CalificacionRequestDTO() {
    }

    public CalificacionRequestDTO(Long id, Float grade, String evaluationType, Alumno student, Curso course) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
        this.course = course;
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

    public Alumno getStudent() {
        return student;
    }

    public void setStudent(Alumno student) {
        this.student = student;
    }

    public Curso getCourse() {
        return course;
    }

    public void setCourse(Curso course) {
        this.course = course;
    }
}
