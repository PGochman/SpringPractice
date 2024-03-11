package com.practice.practice.dto.response;

import com.practice.practice.model.Course;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private Long dni;
    private String address;
    private Set<CourseWithoutStudentResponseDTO> courses;
    private Set<GradeWithoutStudentResponse> grades;
    private Boolean isActive;
    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String name, String lastName, Date birthDate, Long dni, String address, Set<CourseWithoutStudentResponseDTO> courses, Set<GradeWithoutStudentResponse> grades, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.dni = dni;
        this.address = address;
        this.courses = courses;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<CourseWithoutStudentResponseDTO> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseWithoutStudentResponseDTO> courses) {
        this.courses = courses;
    }

    public Set<GradeWithoutStudentResponse> getGrades() {
        return grades;
    }

    public void setGrades(Set<GradeWithoutStudentResponse> grades) {
        this.grades = grades;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }
}
