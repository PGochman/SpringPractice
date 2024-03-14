package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
/**
 * DTO para representar la solicitud de información de un profesor.
 * Contiene los campos necesarios para crear o actualizar un profesor.
 * Se utiliza para los cuerpos de las solicitudes referentes a los profesores.
 */
public class ProfessorRequestDTO {
    /**
     * Id del profesor
     */
    private Long id;
    /**
     * Nombre del profesor.
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el nombre del profesor")
    private String name;
    /**
     * Apellido del profesor.
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el apellido del profesor")
    private String lastName;
    /**
     * Especialidad del profesor.
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar la especialidad del profesor")
    private String specialty;
    /**
     * DNI del profesor.
     * No puede ser nulo
     */
    @NotNull(message = "se debe ingresar el dni del profesor")
    private Long dni;
    /**
     * Estado de actividad del profesor.
     * True para activo, false para inactivo
     */
    private Boolean isActive;
    /**
     * Set de ids de cursos para asociar al profesor
     */
    private Set<Long> coursesId;

    /**
     * Constructor que instancia el id, name, lastname, specialty, dni y coursesId
     * @param id id del profesor
     * @param name nombre del profesor
     * @param lastName apellido del profesor
     * @param specialty especialidad del profesor
     * @param dni dni del profesor
     * @param coursesId set de ids de cursos para asociar al profesor
     */
    public ProfessorRequestDTO(Long id, String name, String lastName, String specialty, Long dni, Set<Long> coursesId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
        this.dni = dni;
        this.coursesId = coursesId;
        this.isActive = true;
    }

    /**
     * Obtiene el dni del profesor
     * @return dni del profesor
     */
    public Long getDni() {
        return dni;
    }

    /**
     * Establece el dni del profesor
     * @param dni dni del profesor
     */
    public void setDni(Long dni) {
        this.dni = dni;
    }
    /**
     * Obtiene el estado de actividad del profesor
     * @return true si esta activo, false si esta inactivo
     */
    public Boolean getActive() {
        return isActive;
    }
    /**
     * Establece el estado de actividad del profesor
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del profesor
     * @return id del profesor
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del profesor
     * @param id id del profesor
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del profesor
     * @return nombre del profesor
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del profesor
     * @param name nombre del profesor
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido del profesor
     * @return apellido del profesor
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Establece el apellido del profesor
     * @param lastName apellido del profesor
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Obtiene la especialidad del profesor
     * @return especialidad del profesor
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Establece la especialidad del profesor
     * @param specialty especialidad del profesor
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * Obtiene el set de ids de cursos a asociar
     * @return set de ids de cursos
     */
    public Set<Long> getCoursesId() {
        return coursesId;
    }

    /**
     * Establece el set de ids de cursos
     * @param coursesId set de ids de cursos a ascociar
     */
    public void setCoursesId(Set<Long> coursesId) {
        this.coursesId = coursesId;
    }

    /**
     * Constructor por defecto
     */
    public ProfessorRequestDTO() {
    }
}
