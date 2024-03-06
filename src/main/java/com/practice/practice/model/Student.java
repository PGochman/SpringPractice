package com.practice.practice.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String address;
    @Column(unique = true)
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 digitos")
    private String dni;
    @ManyToMany
    @JoinTable(
            name= "student_course",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
    private Boolean isActive;
    @OneToMany(mappedBy = "student")
    List<Grade> grades;

    public Student(){
    }

    public Student(String name, String lastName, Date birthDate, String address, String dni, List<Course> courses){
        this.lastName = lastName;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.dni = dni;
        this.courses = courses;
        this.isActive = true;
    }

    public String getDni() {
        return dni;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCourse(Course course){
        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);
        if(course.getStudents() == null){
            course.setStudents(new ArrayList<>());
        }
        course.getStudents().add(this);
    }
}
