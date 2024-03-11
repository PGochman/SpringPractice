package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class CourseRequestDTO {
    private Long id;
    @NotNull(message = "Se debe ingresar el nombre del curso")
    private String name;
    @NotNull(message = "Se debe ingresar el codigo del curso")
    private String code;
    @NotNull(message = "Se debe ingresar una descripcion del curso")
    private String description;
    private Boolean isActive;
    private Set<Long> studentsIds;

    public CourseRequestDTO() {
    }

    public CourseRequestDTO(Long id, String name, String code, String description, Set<Long> studentsIds) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.studentsIds = studentsIds;
        this.isActive = true;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public Set<Long> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(Set<Long> studentsIds) {
        this.studentsIds = studentsIds;
    }
}
