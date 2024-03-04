package com.practice.practice.dto.request;

import com.practice.practice.model.Curso;

import java.util.List;

public class ProfesorRequestDTO {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<Long> coursesId;

    public ProfesorRequestDTO(Long id, String name, String lastName, String specialty, List<Long> coursesId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
        this.coursesId = coursesId;
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

    public List<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Long> coursesId) {
        this.coursesId = coursesId;
    }

    public ProfesorRequestDTO() {
    }
}
