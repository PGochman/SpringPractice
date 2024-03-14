package com.practice.practice.dto.response;

import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
/**
 * DTO para representar la respuesta con información de una calificación.
 * Contiene los campos necesarios para informar sobre una calificación.
 * Se utiliza para las respuestas de las solicitudes referentes a las calificaciones.
 */
public class GradeResponseDTO {
    /**
     * Id de la calificación
     */
    private Long id;
    /**
     * Nota de la calificación
     */
    private Float grade;
    /**
     * Nota de la calificación
     */
    private String evaluationType;
    /**
     * Estudiante asociado a la calificación, sin información de cursos
     */
    private StudentWithoutCourseResponseDTO student;
    /**
     * Curso asociado a la calificación, sin información de estudiantes
     */
    private CourseWithoutStudentResponseDTO course;
    /**
     * Estado de actividad de la calificación
     */
    private Boolean isActive;

    /**
     * Constructor por defecto
     */
    public GradeResponseDTO() {
    }

    /**
     * Constructor que instancia los campos de id, grade, evaluationType,
     * student, course y isActive
     * @param id id de la calificación
     * @param grade nota de la calificación
     * @param evaluationType tipo de evaluación de la calificación
     * @param student estudiante asociado a la calificación
     * @param course curso asociado a la calificación
     * @param isActive estado de actividad de la calificación
     */
    public GradeResponseDTO(Long id, Float grade, String evaluationType, StudentWithoutCourseResponseDTO student, CourseWithoutStudentResponseDTO course, Boolean isActive) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
        this.course = course;
        this.isActive = isActive;
    }

    /**
     * Obtiene el estado de actividad de la calificación
     * @return true si esta activa, false si esta inactiva
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad de la calificación
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id de la calificación
     * @return id de la calificación
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id de la calificación
     * @param id id de la calificación
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la nota de la calificación
     * @return nota de la calificación
     */
    public Float getGrade() {
        return grade;
    }

    /**
     * Establece la nota de la calificación
     * @param grade nota de la calificación
     */
    public void setGrade(Float grade) {
        this.grade = grade;
    }

    /**
     * Obtiene el tipo de evaluación de la calificación
     * @return tipo de evaluación de la calificación
     */
    public String getEvaluationType() {
        return evaluationType;
    }

    /**
     * Establece el tipo de evaluación de la calificación
     * @param evaluationType tipo de evaluación de la calificación
     */
    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    /**
     * Obtiene el estudiante asociado a la calificación, sin información de cursos
     * @return estudiante asociado a la calificación
     */
    public StudentWithoutCourseResponseDTO getStudent() {
        return student;
    }
    /**
     * Establece el estudiante asociado a la calificación
     * @param student estudiante asociado a la calificación, sin información de cursos
     */
    public void setStudent(StudentWithoutCourseResponseDTO student) {
        this.student = student;
    }
    /**
     * Obtiene el curso asociado a la calificación, sin información de estudiantes
     * @return curso asociado a la calificación
     */
    public CourseWithoutStudentResponseDTO getCourse() {
        return course;
    }
    /**
     * Establece el curso asociado a la calificación
     * @param course curso asociado a la calificación, sin información de estudiantes
     */
    public void setCourse(CourseWithoutStudentResponseDTO course) {
        this.course = course;
    }
}
