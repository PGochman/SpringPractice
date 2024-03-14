package com.practice.practice.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * DTO para representar la solicitud de información de un curso.
 * Contiene los campos necesarios para crear o actualizar un curso.
 * Se utiliza para los cuerpos de las solicitudes referentes a los cursos.
 */
public class CourseRequestDTO {
    /**
     * Id del curso
     */
    private Long id;
    /**
     * Nombre del curso.
     * Anotación que indica que no puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el nombre del curso")
    private String name;
    /**
     * Código del curso.
     * Anotación que indica que no puede ser nulo
     */
    @NotNull(message = "Se debe ingresar el codigo del curso")
    private String code;
    /**
     * Descripción del curso.
     * Anotación que indica que no puede ser nulo
     */
    @NotNull(message = "Se debe ingresar una descripcion del curso")
    private String description;
    /**
     * Estado de actividad
     */
    private Boolean isActive;

    /**
     * Constructor por defecto
     */
    public CourseRequestDTO() {
    }

    /**
     * Constructor que inicializa los campos de id, name, code, description y active en true
     * @param id id del curso
     * @param name nombre del curso
     * @param code código del curso
     * @param description descripción del curso
     */
    public CourseRequestDTO(Long id, String name, String code, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.isActive = true;
    }

    /**
     * Obtiene el estado de actividad del CourseRequest
     * @return true si esta activo, false si esta inactivo
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad del CourseRequest
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del CourseRequest
     * @return id del CourseRequest
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del CourseRequest
     * @param id id del del CourseRequest
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del CourseRequest
     * @return nombre del CourseRequest
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del CourseRequest
     * @param name nombre del CourseRequest
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el código del CourseRequest
     * @return código del CourseRequest
     */
    public String getCode() {
        return code;
    }

    /**
     * Establece el código del CourseRequest
     * @param code código del CourseRequest
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtiene la descripción del CourseRequest
     * @return descripción del CourseRequest
     */
    public String getDescription() {
        return description;
    }

    /**
     * Establece la descripción del CourseRequest
     * @param description descripción del CourseRequest
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
