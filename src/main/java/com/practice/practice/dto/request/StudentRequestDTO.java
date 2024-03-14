package com.practice.practice.dto.request;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * DTO para representar la solicitud de información de un estudiante.
 * Contiene los campos necesarios para crear o actualizar un estudiante.
 * Se utiliza para los cuerpos de las solicitudes referentes a los estudiantes.
 */
public class StudentRequestDTO {
    /**
     * Id del estudiante
     */
    private Long id;
    /**
     * Nombre del estudiante.
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar un nombre del estudiante")
    private String name;
    /**
     * Apellido del estudiante
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar un apellido del estudiante")
    private String lastName;
    /**
     * Fecha de nacimiento del estudiante, de tipo YYYY-MM-DD.
     * No puede ser nula, ni en el futuro
     */
    @NotNull(message = "Se debe ingresar una fecha de nacimiento del estudiante")
    @Past(message = "La fecha de nacimiento debe ser anterior a la de hoy")
    private Date birthDate;
    /**
     * Dirección del domicilio del estudiante
     * No puede ser nula
     */
    @NotNull(message = "Se debe ingresar una direccion del estudiante")
    private String address;
    /**
     * DNI del estudiante
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el dni del estudiante")
    private Long dni;
    /**
     * Set de ids de cursos para asociar al estudiante
     */
    private Set<Long> coursesId;

    /**
     * Constructor por defecto
     */
    public StudentRequestDTO(){
    }

    /**
     * Constructor que instancia los campos de id, name, lastName,
     * birthDate, address, dni y coursesId
     * @param id id del estudiante
     * @param name nombre del estudiante
     * @param lastName apellido del estudiante
     * @param birthDate fecha de nacimiento del estudiante
     * @param address dirección de domicilio del estudiante
     * @param dni dni del estudiante
     * @param coursesId set de ids de cursos para inscribir al estudiante
     */
    public StudentRequestDTO(Long id, String name, String lastName, Date birthDate, String address, Long dni, Set<Long> coursesId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.dni = dni;
        this.coursesId = coursesId;
    }

    /**
     * Obtiene el id del estudiante
     * @return id del estudiante
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el dni del estudiante
     * @return dni del estudiante
     */
    public Long getDni() {
        return dni;
    }

    /**
     * Establece el dni del estudiante
     * @param dni dni del estudiante
     */
    public void setDni(Long dni) {
        this.dni = dni;
    }

    /**
     * Establece el id del estudiante
     * @param id id del estudiante
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estudiante
     * @return nombre del estudiante
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del estudiante
     * @param name nombre del estudiante
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido del estudiante
     * @return apellido del estudiante
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido del estudiante
     * @param lastName apellido del estudiante
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la fecha de nacimiento del estudiante
     * @return fecha de nacimiento del estudiante
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del estudiante
     * @param birthDate fecha de nacimiento del estudiante
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene la dirección del domicilio del estudiante
     * @return dirección del domicilio del estudiante
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece la dirección de domicilio del estudiante
     * @param address dirección de domicilio del estudiante
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene el set de ids de cursos en los que inscribir al estudiante
     * @return set de ids de cursos
     */
    public Set<Long> getCoursesId() {
        return coursesId;
    }

    /**
     * Establece el set de ids de cursos en los que inscribir al estudiante
     * @param coursesId set de ids de cursos
     */
    public void setCoursesId(Set<Long> coursesId) {
        this.coursesId = coursesId;
    }
}
