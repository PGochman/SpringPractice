package com.practice.practice.dto.response;

import com.practice.practice.model.Course;

import java.util.List;

public class ProfessorResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<Course> courses;

    public ProfessorResponseDTO() {
    }
    public ProfessorResponseDTO(Long id, String name, String lastName, String specialty, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
        this.courses = courses;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


}
