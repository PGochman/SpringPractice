package com.practice.practice.dto.response;

import com.practice.practice.model.Course;

import java.util.Date;
import java.util.List;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String address;
    private List<CourseWithoutStudentResponseDTO> courses;
    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String name, String lastName, Date birthDate, String address, List<CourseWithoutStudentResponseDTO> courses) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
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

    public List<CourseWithoutStudentResponseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseWithoutStudentResponseDTO> courses) {
        this.courses = courses;
    }

    public String toString(){
        return "ID: " + id + "\n" + "Name: " + name;
    }
}
