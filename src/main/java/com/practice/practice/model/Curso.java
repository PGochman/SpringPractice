package com.practice.practice.model;

import org.w3c.dom.Text;
import com.practice.practice.model.Alumno;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String description;
    @ManyToMany
    private List<Alumno> students;

    public Curso(){
    }

    public Curso(Long id, String name, String code, String description, List<Alumno> students) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.students = students;
    }

    public List<Alumno> getStudents() {
        return students;
    }

    public void setStudents(List<Alumno> students) {
        this.students = students;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
