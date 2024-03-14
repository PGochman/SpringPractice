package com.practice.practice.dto.response;
/**
 * DTO para representar la respuesta con información de una calificacion sin estudiantes asociados.
 * Contiene los campos necesarios para informar sobre una calificacion sin estudiantes asociados.
 * Se utiliza para las respuestas de las solicitudes referentes a estudiantes
 * que necesitan información de calificaciones.
 */
public class GradeWithoutStudentResponse {
    /**
     * Id de la calificación
     */
    private Long id;
    /**
     * Nota de la calificación
     */
    private Float grade;
    /**
     * Tipo de evaluación de la calificación
     */
    private String evaluationType;
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
    public GradeWithoutStudentResponse() {
    }
    /**
     * Constructor que instancia id, grade, evaluationType y student
     * @param id id de la calificación
     * @param grade nota de la calificación
     * @param evaluationType tipo de evaluación de la calificación
     * @param course curso asociado a la calificación
     * @param isActive estado de actividad de la calificación
     */
    public GradeWithoutStudentResponse(Long id, Float grade, String evaluationType, CourseWithoutStudentResponseDTO course, Boolean isActive) {
        this.id = id;
        this.grade = grade;
        this.evaluationType = evaluationType;
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
     * Obtiene el curso asociado a la calificación
     * @return curso asociado a la calificación
     */
    public CourseWithoutStudentResponseDTO getCourse() {
        return course;
    }
    /**
     * Establece el curso asociado a la calificación
     * @param course curso asociado a la calificación
     */
    public void setCourse(CourseWithoutStudentResponseDTO course) {
        this.course = course;
    }
}
