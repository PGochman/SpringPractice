package com.practice.practice.dto.response;

import java.util.Date;
/**
 * DTO para representar la respuesta con información de un estudiante sin información de cursos.
 * Contiene los campos necesarios para informar sobre un estudiante sin información de los cursos asociados.
 * Se utiliza para las respuestas de las solicitudes referentes a notas y cursos
 * que necesitan información de estudiantes.
 */
public class StudentWithoutCourseResponseDTO {
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
     * Dirección de domicilio del estudiante
     */
    private String address;
    /**
     * Estado de actividad del estudiante
     */
    private Boolean isActive;
    /**
     * Constructor que instancia los campos de id, name, lastName, birthDate,
     * grades y isActive
     * @param id id del estudiante
     * @param name nombre del estudiante
     * @param lastName apellido del estudiante
     * @param birthDate fecha de nacimiento del estudiante
     * @param address dirección de domicilio del estudiante
     * @param isActive estado de actividad del estudiante
     */
    public StudentWithoutCourseResponseDTO(Long id, String name, String lastName, Date birthDate, String address, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.isActive = isActive;
    }

    /**
     * Constructor por defecto
     */
    public StudentWithoutCourseResponseDTO() {
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
}
