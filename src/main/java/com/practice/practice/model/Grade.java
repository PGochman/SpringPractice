package com.practice.practice.model;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * Definición de la tabla grade en la base de datos.
 * Clase que representa una calificacion asignada a un
 * estudiante para un curso especifico.
 * Instancias con nota, tipo de evaluacion, y estudiante y
 * curso asociados.
 */
@Entity
public class Grade {
    /**
     * ID generado automaticamente, incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nota numerica de la calificación
     */
    private Float grade;
    /**
     * Tipo de evaluación que se esta calificando
     */
    private String evaluationType;
    /**
     * Estudiante al que se le asigna la calificación
     * @see Student
     */
    @ManyToOne
    private Student student;
    /**
     * Curso al que se le asigna la calificación
     */
    @ManyToOne
    private Course course;
    /**
     * Estado de actividad de la nota.
     * Utilizado para borrado lógico
     */
    private Boolean isActive;
    /**
     * Constructor por defecto de la calificación
     */
    public Grade(){
    }
    /**
     * Constructor con atributos de grade, evaluationType,
     * student y grade inicializados
     * @param grade Nota de la calificación
     * @param evaluationType Tipo de evaluación que se califica
     * @param student Estudiante que se califica
     * @param course Curso de la calificación
     */
    public Grade(Float grade, String evaluationType, Student student, Course course) {
        this.grade = grade;
        this.evaluationType = evaluationType;
        this.student = student;
        this.course = course;
        this.isActive = true;
    }
    /**
     * Obtiene el estado de actividad de la calificación.
     * @return true si esta activa, false si esta desactiva
     */
    public Boolean getActive() {
        return isActive;
    }
    /**
     * Establece el estado de actividad de la calificación.
     * @param active true para activar la calificación,
     * false para desactivarla
     */
    public void setActive(Boolean active) {
        isActive = active;
    }
    /**
     * Obtiene el estudiante al que esta asignada la calificación.
     * @return estudiante asociado a la calificación
     */
    public Student getStudent() {
        return student;
    }
    /**
     * Establece un estudiante al que asociar la calificación
     * @param student estudiante a calificar
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    /**
     * Obtiene el curso al que esta asociada la calificación.
     * @return Curso asociado a la calificación
     */
    public Course getCourse() {
        return course;
    }
    /**
     * Establece un curso al que asociar la calificación
     * @param course curso en el que se califica
     */
    public void setCourse(Course course) {
        this.course = course;
    }
    /**
     * Obtiene el identificador único de la calificación
     * @return id de la calificación
     */
    public Long getId() {
        return id;
    }
    /**
     * Establece el id de la calificación
     * @param id identificador único de la calificación
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
     * @param grade nota, numero entre uno y diez
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
     * @param evaluationType tipo de evaluación (Parcial,
     * final, TP, etc.)
     */
    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }
}
