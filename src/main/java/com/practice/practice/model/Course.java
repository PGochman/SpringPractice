package com.practice.practice.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Definición de la tabla courses en la base de datos.
 * Clase que representa un curso, asociado a los estudiantes
 * que estudian este curso, y las notas de dichos estudiantes.
 * Instancias con información del nombre, código, estudiantes
 * y notas del curso.
 */
@Entity
public class Course {
    /**
     * ID generado automaticamente, incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del curso
     */
    private String name;
    /**
     * Código del curso, atributo unico para la tabla
     */
    @Column(unique = true)
    private String code;
    /**
     * Breve descripción del curso
     */
    private String description;
    /**
     * Set de estudiantes anotados en el Curso
     * @see Student
     */
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
    /**
     * Propiedad de activo, indica si un elemento esta activo o no
     * Utilizado para borrado lógico
     */
    private Boolean isActive;
    /**
     * Set de notas que se le asignaron al estudiante
     * @see Grade
     */
    @OneToMany(mappedBy = "course")
    Set<Grade> grades;

    /**
     * Constructor por defecto para la clase
     */
    public Course(){
    }

    /**
     * Constructor con atributos name, code, description y
     * students inicializados, y estado de actividad en activo
     * @param name Nombre del curso
     * @param code Codigo del curso
     * @param description Descripción del curso
     * @param students Estudiantes asociados al curso
     */
    public Course(String name, String code, String description, Set<Student> students) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.students = students;
        this.isActive = true;
    }
    /**
     * Obtiene las notas asociadas al curso
     * @return set de notas asociadas al curso
     */
    public Set<Grade> getGrades() {
        return grades;
    }
    /**
     * Establece y asocia un set de notas al curso
     * @param grades set de notas
     */
    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
    /**
     * Obtiene los estudiantes asociados al curso
     * @return set de estudiantes asociados al curso
     */
    public Set<Student> getStudents() {
        return students;
    }
    /**
     * Establece y asocia un set de estudiantes al curso
     * @param students set de estudiantes
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }
    /**
     * Obtiene el estado de activación del curso
     * @return true si el curso esta activo, false si esta desactivo
     */
    public Boolean getActive() {
        return isActive;
    }
    /**
     * Establece el estado de activación del curso
     * @param active true para activar el curso, false para desactivarlo
     */
    public void setActive(Boolean active) {
        isActive = active;
    }
    /**
     * Obtiene el identificador único del curso
     * @return id del curso
     */
    public Long getId() {
        return id;
    }
    /**
     * Establece el id del curso
     * @param id numero de identificador único
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
     * @return código
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
     * @return código
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
}
