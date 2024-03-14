package com.practice.practice.dto.response;

import com.practice.practice.model.Student;

import java.util.List;
import java.util.Set;
/**
 * DTO para representar la respuesta con información de un curso.
 * Contiene los campos necesarios para informar sobre un curso.
 * Se utiliza para las respuestas de las solicitudes referentes a los cursos.
 */
public class CourseResponseDTO {
    /**
     * id del curso
     */
    private Long id;
    /**
     * Nombre del curso
     */
    private String name;
    /**
     * Código del curso
     */
    private String code;
    /**
     * Descripción del curso
     */
    private String description;
    /**
     * Set de estudiantes inscriptos en el curso
     */
    private Set<StudentWithoutCourseResponseDTO> students;
    /**
     * Set de calificaciones dadas en el curso
     */
    private Set<GradeWithoutCourseResponse> grades;
    /**
     * Estado de actividad del curso
     */
    private Boolean isActive;

    /**
     * Constructor por defecto
     */
    public CourseResponseDTO() {
    }

    /**
     * Constructor que instancia los campos de id, name, code, description,
     * students, grades y isActive
     * @param id
     * @param name
     * @param code
     * @param description
     * @param students
     * @param grades
     * @param isActive
     */
    public CourseResponseDTO(Long id, String name, String code, String description, Set<StudentWithoutCourseResponseDTO> students, Set<GradeWithoutCourseResponse> grades, Boolean isActive){
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.students = students;
        this.grades = grades;
        this.isActive = isActive;
    }

    /**
     * Obtiene el estado de actividad del curso
     * @return true si esta activo, false si esta inactivo
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad del curso
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del curso
     * @return id del curso
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del curso
     * @param id id del curso
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del curso
     * @return nombre del curso
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del curso
     * @param name nombre del curso
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el código del curso
     * @return código del curso
     */
    public String getCode() {
        return code;
    }

    /**
     * Establece el código del curso
     * @param code código del curso
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtiene la descripción del curso
     * @return descripción del curso
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del curso
     * @param description descripción del curso
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtiene los estudiantes asociados al curso
     * @return set de estudiantes asociados al curso
     */
    public Set<StudentWithoutCourseResponseDTO> getStudents() {
        return students;
    }

    /**
     * Establece los estudiantes asociados al curso
     * @param students set de estudiantes asociados al curso
     */
    public void setStudents(Set<StudentWithoutCourseResponseDTO> students) {
        this.students = students;
    }

    /**
     * Obtiene las notas asociadas al curso
     * @return set de notas asociadas al curso
     */
    public Set<GradeWithoutCourseResponse> getGrades() {
        return grades;
    }

    /**
     * Establece las notas asociadas al curso
     * @param grades set de notas asociadas al curso
     */
    public void setGrades(Set<GradeWithoutCourseResponse> grades) {
        this.grades = grades;
    }
}
