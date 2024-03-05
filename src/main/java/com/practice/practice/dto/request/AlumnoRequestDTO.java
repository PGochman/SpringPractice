package com.practice.practice.dto.request;

import com.practice.practice.model.Curso;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public class AlumnoRequestDTO {
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
    private List<Long> coursesId;

    public AlumnoRequestDTO(){
    }

    public AlumnoRequestDTO(Long id, String name, String lastName, Date birthDate, String address, List<Long> coursesId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
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
