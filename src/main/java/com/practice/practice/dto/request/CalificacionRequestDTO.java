package com.practice.practice.dto.request;

import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class CalificacionRequestDTO {
    private Long id;
    private Float grade;
    private String evaluationType;
    private Long studentId;
    private Long courseId;

    public CalificacionRequestDTO() {
    }

    public CalificacionRequestDTO(Long id, Float grade, String evaluationType, Long studentId, Long courseId) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.studentId = studentId;
        this.courseId = courseId;
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
