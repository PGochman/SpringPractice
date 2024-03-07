package com.practice.practice.dto.request;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public class StudentRequestDTO {
    private Long id;
    @NotNull(message = "Se debe ingresar un nombre del estudiante")
    private String name;
    @NotNull(message = "Se debe ingresar un apellido del estudiante")
    private String lastName;
    @NotNull(message = "Se debe ingresar una fecha de nacimiento del estudiante")
    @Past(message = "La fecha de nacimiento debe ser anterior a la de hoy")
    private Date birthDate;
    @NotNull(message = "Se debe ingresar una direccion del estudiante")
    private String address;
    @NotNull(message = "Se debe ingresar el dni del estudiante")
    private Long dni;
    private List<Long> coursesId;

    public StudentRequestDTO(Long dni){
        this.dni = dni;
    }

    public StudentRequestDTO(Long id, String name, String lastName, Date birthDate, String address, Long dni, List<Long> coursesId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.dni = dni;
        this.coursesId = coursesId;
    }
    public Long getId() {
        return id;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
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

    public List<Long> getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(List<Long> coursesId) {
        this.coursesId = coursesId;
    }
}
