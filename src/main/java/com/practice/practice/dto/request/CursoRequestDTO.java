package com.practice.practice.dto.request;

import com.practice.practice.model.Alumno;

import java.util.List;

public class CursoRequestDTO {
    private Long id;
    private String name;
    private String code;
    private String description;
    private List<Long> studentsIds;

    public CursoRequestDTO() {
    }

    public CursoRequestDTO(Long id, String name, String code, String description, List<Long> studentsIds) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.studentsIds = studentsIds;
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

    public List<Long> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(List<Long> studentsIds) {
        this.studentsIds = studentsIds;
    }
}
