package com.practice.practice.dto.response;
/**
 * DTO para representar la respuesta con información de un curso sin estudiantes asociados.
 * Contiene los campos necesarios para informar sobre un curso sin información de los estudiantes asociados.
 * Se utiliza para las respuestas de las solicitudes referentes a notas y estudiantes
 * que necesitan información de cursos.
 */
public class CourseWithoutStudentResponseDTO {
    /**
     * Id del curso
     */
    private Long id;
    /**
     * Nombre del curso
     */
    private String name;
    /**
     * Código del curso
     */
    private String code;
    /**
     * Descripción del curso
     */
    private String description;
    /**
     * Estado de actividad del curso
     */
    private Boolean isActive;

    /**
     * Constructor que instancia los campos de id, name, code, description, isActive
     * @param id id del curso
     * @param name nombre del curso
     * @param code código del curso
     * @param description descripción del curso
     * @param isActive estado de actividad del curso
     */

    public CourseWithoutStudentResponseDTO(Long id, String name, String code, String description, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.isActive = isActive;
    }

    /**
     * Obtiene el estado de actividad del curso
     * @return true si esta activo, false si esta inactivo
     */
    public Boolean getActive() {
        return isActive;
    }

    /**
     * Establece el estado de actividad del curso
     * @param active true para activar, false para desactivar
     */
    public void setActive(Boolean active) {
        isActive = active;
    }

    /**
     * Obtiene el id del curso
     * @return id del curso
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del curso
     * @param id id del curso
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
     * @return código del curso
     */
    public String getCode() {
        return code;
    }

    /**
     * Establece el código del curso
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Obtiene la descripción del curso
     * @return descripción del curso
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
