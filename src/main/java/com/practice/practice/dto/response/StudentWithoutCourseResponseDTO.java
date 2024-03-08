package com.practice.practice.dto.response;

import java.util.Date;

public class StudentWithoutCourseResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String address;
    private Boolean isActive;

    public StudentWithoutCourseResponseDTO(Long id, String name, String lastName, Date birthDate, String address, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.isActive = isActive;
    }

    public StudentWithoutCourseResponseDTO() {
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
}
