package com.practice.practice.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definición de la tabla professor en la base de datos.
 * Clase que representa un profesor.
 * Instancias con nombre, apellido, dni, apellido,
 * especialidad y cursos que dicta.
 */
@Entity
public class Professor {
    /**
     * Identificación unica, generada automaticamente, incremental.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * DNI, documento nacional de identidad. 8 dígitos.
     * Verifica que no se cree dos veces el mismo profesor
     */
    @Column(unique = true)
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 digitos")
    private String dni;
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
     * Estado de actividad del profesor.
     * Utilizado para borrado lógico.
     */
    private Boolean isActive;
    /**
     * Set de cursos que dicta el profesor
     * @see Course
     */
    @ManyToMany
    private Set<Course> courses;

    /**
     * Constructor por defecto
     */
    public Professor() {
    }

    /**
     * Constructor que inicializa los atributos de
     * nombre, apellido, dni y especialidad, y estado de
     * actividad en activo
     * @param dni dni del profesor
     * @param name nombre del profesor
     * @param lastName apellido del profesor
     * @param specialty especialidad del profesor
     */
    public Professor(String dni, String name, String lastName, String specialty) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.specialty = specialty;
        this.courses = new HashSet<>();
        this.isActive = true;
    }

    /**
     * Obtención del dni del profesor
     * @return dni del profesor
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el dni del profesor
     * @param dni dni del profesor
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Obtiene el estado de actividad del profesor
     * @return true si esta activo, false si esta
     * inactivo
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
     * Obtiene los cursos que dicta el profesor
     * @return cursos asociados al profesor
     */
    public Set<Course> getCourses() {
        return courses;
    }
    /**
     * Establece los cursos que dicta el profesor y
     * los asocia
     * @param courses cursos para asociar al profesor
     */
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
     * @param id identificador único del profesor
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
}
