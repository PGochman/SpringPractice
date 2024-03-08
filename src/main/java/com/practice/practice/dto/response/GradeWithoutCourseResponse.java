package com.practice.practice.dto.response;

public class GradeWithoutCourseResponse {
    private Long id;
    private Float grade;
    private String evaluationType;
    private StudentWithoutCourseResponseDTO student;
    private Boolean isActive;

    public GradeWithoutCourseResponse() {
    }

    public GradeWithoutCourseResponse(Long id, Float grade, String evaluationType, StudentWithoutCourseResponseDTO student) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
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

    public StudentWithoutCourseResponseDTO getStudent() {
        return student;
    }

    public void setStudent(StudentWithoutCourseResponseDTO student) {
        this.student = student;
    }
}
