package com.practice.practice.service;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;

import java.util.List;
import java.util.Set;
/**
 * Interfaz para definir los métodos que manejan la lógica de negocio relacionada con los cursos.
 */
public interface CourseService {
    /**
     * Crea un nuevo curso con la información proporcionada
     * @param courseRequestDTO DTO de petición de curso con la información necesaria para crear un curso
     * @return DTO de respuesta del curso creado
     */
    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);

    /**
     * Encuentra un curso por id
     * @param id Id del curso a encontrar
     * @return Curso encontrado
     * @throws ExceptionNotFound Si no se encuentra el curso
     */
    Course getCourseById(Long id) throws ExceptionNotFound;

    /**
     * Encuentra un curso por id, y devuelve su DTO de respuesta
     * @param id Id del curso a encontrar
     * @return DTO de respuesta del curso encontrado
     * @throws ExceptionNotFound Si no se encuentra el curso
     */
    CourseResponseDTO findCourseById(Long id) throws ExceptionNotFound;

    /**
     * Encuentra un set de cursos a partir de un set de ids
     * @param coursesIds Ids de los cursos a encontrar
     * @return Set de cursos encontrados
     * @throws ExceptionNotFound Si algún curso no se encuentra
     */
    Set<Course> getAllCoursesByIds(Set<Long> coursesIds) throws ExceptionNotFound;

    /**
     * Obtiene todos los cursos, y devuelve una lista de DTO de respuesta
     * @return Lista de DTO de respuesta con todos los cursos
     */
    List<CourseResponseDTO> getAllCourses();

    /**
     * Actualiza la información de un curso, y devuelve su DTO de respuesta con la información actualizada
     * @param courseRequestDTO DTO de petición de curso con la información para actualizar
     * @throws ExceptionNotFound Si el curso que se quiere actualizar no se encuentra
     */
    void updateCourse(CourseRequestDTO courseRequestDTO) throws ExceptionNotFound;

    /**
     * Desactiva un curso
     * @param id Id del curso a desactivar
     * @throws ExceptionNotFound Si no se encuentra el curso
     * @throws ExceptionDeletedData Si el curso ya está inactivo
     */
    void deactivateCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData;
    /**
     * Reactiva un curso
     * @param id Id del curso a reactivar
     * @throws ExceptionNotFound Si no se encuentra el curso
     * @throws ExceptionDeletedData Si el curso ya está activo
     */
    void restoreCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData;
}
