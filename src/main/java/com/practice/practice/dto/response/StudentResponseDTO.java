package com.practice.practice.dto.response;

import com.practice.practice.model.Course;

import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * DTO para representar la respuesta con información de un estudiante.
 * Contiene los campos necesarios para informar sobre un estudiante.
 * Se utiliza para las respuestas de las solicitudes referentes a los estudiantes.
 */
public class StudentResponseDTO {
    /**
     * Id del estudiante
     */
    private Long id;
    /**
     * Nombre del estudiante
     */
    private String name;
    /**
     * Apellido del estudiante
     */
    private String lastName;
    /**
     * Fecha de nacimiento del estudiante
     */
    private Date birthDate;
    /**
     * DNI del estudiante
     */
    private Long dni;
    /**
     * Dirección de domicilio del estudiante
     */
    private String address;
    /**
     * Set de cursos asociados al estudiante, sin información de estudiantes
     */
    private Set<CourseWithoutStudentResponseDTO> courses;
    /**
     * Set de calificaciones asociadas al estudiante, sin información de estudiantes
     */
    private Set<GradeWithoutStudentResponse> grades;
    /**
     * Estado de actividad del estudiante
     */
    private Boolean isActive;

    /**
     * Constructor por defecto
     */
    public StudentResponseDTO() {
    }

    /**
     * Constructor que instancia los campos de id, name, lastName, birthDate,
     * dni, address, courses, grades y isActive
     * @param id id del estudiante
     * @param name nombre del estudiante
     * @param lastName apellido del estudiante
     * @param birthDate fecha de nacimiento del estudiante
     * @param dni dni del estudiante
     * @param address dirección de domicilio del estudiante
     * @param courses cursos asociados al estudiante
     * @param grades calificaciones asociadas al estudiante
     * @param isActive estado de actividad del estudiante
     */
    public StudentResponseDTO(Long id, String name, String lastName, Date birthDate, Long dni, String address, Set<CourseWithoutStudentResponseDTO> courses, Set<GradeWithoutStudentResponse> grades, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.dni = dni;
        this.address = address;
        this.courses = courses;
        this.grades = grades;
        this.isActive = isActive;
    }

    /**
     * Obtiene el estado de actividad del estudiante
     * @return true si esta activo, false si esta inactivo
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad del estudiante
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del estudiante
     * @return id del estudiante
     */
    public Long getId() {
        return id;
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
     * Obtiene la dirección de domicilio del estudiante
     * @return dirección de domicilio del estudiante
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
     * Obtiene los cursos en los que está inscripto el estudiante
     * @return cursos asociados al estudiante
     */
    public Set<CourseWithoutStudentResponseDTO> getCourses() {
        return courses;
    }

    /**
     * Establece los cursos en los que inscirbir al estudiante
     * @param courses cursos para asociar al estudiante
     */
    public void setCourses(Set<CourseWithoutStudentResponseDTO> courses) {
        this.courses = courses;
    }

    /**
     * Obtiene las calificaciones asignadas al estudiante
     * @return calificaciones asociadas al estudiante
     */
    public Set<GradeWithoutStudentResponse> getGrades() {
        return grades;
    }

    /**
     * Establece las calificaciones a asignar al estudiante
     * @param grades calificaciones para asociar al estudiante
     */
    public void setGrades(Set<GradeWithoutStudentResponse> grades) {
        this.grades = grades;
    }

    /**
     * Obtiene el dni del estudiante
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
}
