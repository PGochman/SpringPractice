package com.practice.practice.dto.response;

import com.practice.practice.model.Student;

import java.util.List;

public class CourseResponseDTO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private List<StudentWithoutCourseResponseDTO> students;
    private List<GradeWithoutCourseResponse> grades;
    private Boolean isActive;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(Long id, String name, String code, String description, List<StudentWithoutCourseResponseDTO> students, List<GradeWithoutCourseResponse> grades, Boolean isActive){
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.students = students;
        this.grades = grades;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StudentWithoutCourseResponseDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentWithoutCourseResponseDTO> students) {
        this.students = students;
    }

    public List<GradeWithoutCourseResponse> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeWithoutCourseResponse> grades) {
        this.grades = grades;
    }
}
