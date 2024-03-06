package com.practice.practice.model;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float grade;
    private String evaluationType;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;
    private Boolean isActive;

    public Grade(){
    }
    public Grade(Float grade, String evaluationType, Student student, Course course) {
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
        this.course = course;
        this.isActive = true;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
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
