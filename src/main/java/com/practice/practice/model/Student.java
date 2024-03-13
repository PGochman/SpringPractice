package com.practice.practice.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Definición de la tabla student en la base de datos.
 * Clase que representa un estudiante.
 * Instancias con nombre, apellido, fecha de nacimiento,
 * dirección, dni, cursos a los que asiste, y notas asignadas
 */
@Entity
public class Student {
    /**
     * ID generado automaticamente, incremental
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Fecha de nacimiento, formato "YYYY-MM-DD"
     */
    private Date birthDate;
    /**
     * Dirección del domicilio del estudiante
     */
    private String address;
    /**
     * DNI, documneto nacional de identidad del estudiante
     */
    @Column(unique = true)
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 digitos")
    private String dni;
    /**
     * Cursos a los que asiste el estudiante
     * @see Course
     */
    @ManyToMany
    @JoinTable(
            name= "student_course",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
    /**
     * Estado de actividad del estudiante.
     * Utilizado para borrado lógico
     */
    private Boolean isActive;
    /**
     * Notas asignadas al estudiante
     * @see Student
     */
    @OneToMany(mappedBy = "student")
    Set<Grade> grades;
    /**
     * Constructor por defecto del estudiante
     */
    public Student(){
    }
    /**
     * Constructor que instancia los campos de nombre,
     * apellido, fecha de nacimiento, dirección, dni,
     * cursos a los que asiste, y estado de actividad en
     * true
     * @param name nombre del estudiante
     * @param lastName apellido del estudiante
     * @param birthDate fecha de nacimiento del estudiante
     * @param address dirección de domicilio del estudiante
     * @param dni dni del estudiante
     * @param courses cursos a los que asiste el estudiante
     */
    public Student(String name, String lastName, Date birthDate, String address, String dni, Set<Course> courses){
        this.lastName = lastName;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.dni = dni;
        this.courses = courses;
        this.isActive = true;
    }
    /**
     * Obtiene el dni del estudiante
     * @return dni del estudiante
     */
    public String getDni() {
        return dni;
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
        this.isActive = active;
    }
    /**
     * Establece el dni del estudiante
     * @param dni dni del estudiante, 8 dígitos
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * Obtiene los cursos a los que asiste el estudiante
     * @return Set de cursos a los que asiste el estudiante
     */
    public Set<Course> getCourses() {
        return courses;
    }
    /**
     * Establece y asocia los cursos a los que asiste el estudiante
     * @param courses Set de cursos en los que inscribir al estudiante
     */
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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
     * Establece el nombre del estudiante
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
     * @param date fecha de nacimiento, formato YYYY-MM-DD
     */
    public void setBirthDate(Date date) {
        this.birthDate = date;
    }
    /**
     * Obtiene la dirección del estudiante
     * @return dirección del estudiante
     */
    public String getAddress() {
        return address;
    }
    /**
     * Establece la dirección del estudiante
     * @param address dirección del estudiante
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Obtiene las notas del estudiante
     * @return notas asignadas al estudiante
     */
    public Set<Grade> getGrades() {
        return grades;
    }
    /**
     * Establece y asocia las notas asignadas al estudiante
     * @param grades notas para asignar al estudiante
     */
    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }
}
