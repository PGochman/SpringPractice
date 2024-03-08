package com.practice.practice.dto.response;

public class GradeWithoutStudentResponse {
    private Long id;
    private Float grade;
    private String evaluationType;
    private CourseWithoutStudentResponseDTO course;
    private Boolean isActive;

    public GradeWithoutStudentResponse() {
    }

    public GradeWithoutStudentResponse(Long id, Float grade, String evaluationType, CourseWithoutStudentResponseDTO course, Boolean isActive) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.course = course;
        this.isActive = isActive;
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

    public CourseWithoutStudentResponseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseWithoutStudentResponseDTO course) {
        this.course = course;
    }
}
