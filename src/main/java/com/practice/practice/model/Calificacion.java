package com.practice.practice.model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float grade;
    private String evaluationType;
    @ManyToOne
    private Alumno student;
    @ManyToOne
    private Curso course;

    public Calificacion(){
    }
    public Calificacion(Long id, Float grade, String evaluationType, Alumno student, Curso course) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
        this.course = course;
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
}
