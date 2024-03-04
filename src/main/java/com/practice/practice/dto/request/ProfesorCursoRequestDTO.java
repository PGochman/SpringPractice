package com.practice.practice.dto.request;

public class ProfesorCursoRequestDTO {
    private Long id;
    private Long profesorId;
    private Long courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public ProfesorCursoRequestDTO(Long id, Long profesorId, Long courseId) {
        this.id = id;
        this.profesorId = profesorId;
        this.courseId = courseId;
    }
}
