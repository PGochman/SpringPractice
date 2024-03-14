package com.practice.practice.dto.request;

import javax.validation.constraints.*;
/**
 * DTO para representar la solicitud de información de una calificación.
 * Contiene los campos necesarios para crear o actualizar una calificación.
 * Se utiliza para los cuerpos de las solicitudes referentes a las calificaciones.
 */
public class GradeRequestDTO {
    /**
     * Id de la calificación
     */
    private Long id;
    /**
     * Nota de la calificación
     * No puede ser nulo, y su valor debe estar entre 1 y 10
     */
    @NotNull(message = "Se debe ingresar una nota de la calificacion")
    @Min(value = 1, message = "El valor mínimo de la nota es 1")
    @Max(value = 10, message = "El valor máximo de la nota es 10")
    private Float grade;
    /**
     * Tipo de evaluación de la calificación
     * No puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el tipo de evaluación")
    private String evaluationType;
    /**
     * ID del estudiante al que se asigna la calificación
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del estudiante no puede ser nulo, enviar un valor")
    @Positive(message = "El id del estudiante debe ser un numero positivo")
    private Long studentId;
    /**
     * ID del curso al que pertenece la calificación
     * No puede ser nulo, ni negativo
     */
    @NotNull(message = "El id del curso no puede ser nulo, enviar un valor")
    @Positive(message = "El id del curso debe ser un numero positivo")
    private Long courseId;
    /**
     * Estado de actividad de la calificación
     * True si esta activa, false si esta desactiva
     */
    private Boolean isActive;

    /**
     * Constructor por defecto
     */
    public GradeRequestDTO() {
    }

    /**
     * Constructor que instancia los campor de id, grade, evaluationType
     * studentId y courseId, y campo isActive en true
     * @param id id del GradeRequest
     * @param grade nota del GradeRequest
     * @param evaluationType Tipo de evaluación del GradeRequest
     * @param studentId ID del estudiante a asociar
     * @param courseId ID del curso a asociar
     */
    public GradeRequestDTO(Long id, Float grade, String evaluationType, Long studentId, Long courseId) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.studentId = studentId;
        this.courseId = courseId;
        this.isActive = true;
    }

    /**
     * Obtiene el estado de actividad del GradeRequest
     * @return true para activo, false para inactivo
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad del GradeRequest
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del GradeRequest
     * @return id del GradeRequest
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del GradeRequest
     * @param id id del GradeRequest
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la nota del GradeRequest
     * @return nota del GradeRequest
     */
    public Float getGrade() {
        return grade;
    }
    /**
     * Establece la nota del GradeRequest
     * @param grade nota del GradeRequest
     */
    public void setGrade(Float grade) {
        this.grade = grade;
    }
    /**
     * Obtiene el tipo de evaluación del GradeRequest
     * @return tipo de evaluación del GradeRequest
     */
    public String getEvaluationType() {
        return evaluationType;
    }
    /**
     * Establece el tipo de evaluación del GradeRequest
     * @param evaluationType tipo de evaluación del GradeRequest
     */
    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    /**
     * Obtiene el ID del estudiante
     * @return id del estudiante
     */
    public Long getStudentId() {
        return studentId;
    }
    /**
     * Establece el ID del estudiante
     * @param studentId id del estudiante
     */
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    /**
     * Obtiene el ID del curso
     * @return id del curso
     */
    public Long getCourseId() {
        return courseId;
    }
    /**
     * Establece el ID del curso
     * @param courseId id del curso
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
