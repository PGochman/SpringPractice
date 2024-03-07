package com.practice.practice.dto.response;

import com.practice.practice.model.Course;
import com.practice.practice.model.Student;

public class GradeResponseDTO {
    private Long id;
    private Float grade;
    private String evaluationType;
    private StudentWithoutCourseResponseDTO student;
    private CourseWithoutStudentResponseDTO course;

    public GradeResponseDTO() {
    }

    public GradeResponseDTO(Long id, Float grade, String evaluationType, StudentWithoutCourseResponseDTO student, CourseWithoutStudentResponseDTO course) {
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

    public StudentWithoutCourseResponseDTO getStudent() {
        return student;
    }

    public void setStudent(StudentWithoutCourseResponseDTO student) {
        this.student = student;
    }
    public CourseWithoutStudentResponseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseWithoutStudentResponseDTO course) {
        this.course = course;
    }
}
