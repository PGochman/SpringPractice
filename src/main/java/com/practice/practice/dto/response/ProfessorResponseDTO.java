package com.practice.practice.dto.response;

import com.practice.practice.model.Course;

import java.util.List;
import java.util.Set;
/**
 * DTO para representar la respuesta con información de un profesor.
 * Contiene los campos necesarios para informar sobre un profesor.
 * Se utiliza para las respuestas de las solicitudes referentes a los profesores.
 */
public class ProfessorResponseDTO {
    /**
     * Id del profesor
     */
    private Long id;
    /**
     * Nombre del profesor
     */
    private String name;
    /**
     * Apellido del profesor
     */
    private String lastName;
    /**
     * Especialidad del profesor
     */
    private String specialty;
    /**
     * Estado de actividad del profesor
     */
    private Boolean isActive;
    /**
     * DNI del profesor
     */
    private Long dni;
    /**
     * Set de cursos que dicta el profesor
     */
    private Set<CourseResponseDTO> courses;

    /**
     * Profesor por defecto
     */
    public ProfessorResponseDTO() {
    }

    /**
     * Constructor que instancia los campos de id, name, lastName,
     * specialty, courses, isActive y dni
     * @param id id del profesor
     * @param name nombre del profesor
     * @param lastName apellido del profesor
     * @param specialty especialidad del profesor
     * @param courses cursos que dicta el profesor
     * @param isActive estado de actividad del profesor
     * @param dni dni del profesor
     */
    public ProfessorResponseDTO(Long id, String name, String lastName, String specialty, Set<CourseResponseDTO> courses, Boolean isActive, Long dni) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
        this.courses = courses;
        this.isActive = isActive;
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
     * Obtiene los cursos que dicta el profesor
     * @return cursos asociados al profesor
     */
    public Set<CourseResponseDTO> getCourses() {
        return courses;
    }

    /**
     * Establece los cursos que dicta el profesor
     * @param courses set de cursos a asociar al profesor
     */
    public void setCourses(Set<CourseResponseDTO> courses) {
        this.courses = courses;
    }
}
