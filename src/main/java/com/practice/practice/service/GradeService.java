package com.practice.practice.service;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Grade;

import java.util.List;
/**
 * Interfaz para definir los métodos que manejan la lógica de negocio relacionada con las calificaciones.
 */
public interface GradeService {
    /**
     * Crea una nueva calificación, y devuelve su DTO de respuesta
     * @param gradeRequestDTO DTO de petición con la información necesaria para crear una calificación
     * @return DTO de respuesta de la calificación creada
     * @throws ExceptionNotFound Si no se encuentra el estudiante o curso a asociar
     */
    GradeResponseDTO registerGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound;

    /**
     * Encuentra una calificación por id, y devuelve su DTO de respuesta
     * @param id Id de la calificación a encontrar
     * @return DTO de respuesta de la calificación encontrada
     * @throws ExceptionNotFound Si no se encuentra la calificación
     */
    GradeResponseDTO findGradeById(Long id) throws ExceptionNotFound;

    /**
     * Encuentra todas las calificaciones de un estudiante
     * @param studentId Id del estudiante del cual encontrar las calificaciones
     * @return Lista de DTO de respuesta de las calificaciones encontradas
     */
    List<GradeResponseDTO> getGradeByStudentId(Long studentId);

    /**
     * Encuentra todas las calificaciones de un curso
     * @param courseId Id del curso del cual encontrar las calificaciones
     * @return Lista de DTO de respuesta de las calificaciones encontradas
     */
    List<GradeResponseDTO> getGradeByCourseId(Long courseId);

    /**
     * Obtiene todas las calificaciones
     * @return Lista de DTO de respuesta de las calificaciones encontradas
     */
    List<GradeResponseDTO> getAllGrades();

    /**
     * Actualiza la información de una calificación
     * @param gradeRequestDTO DTO de petición de calificación con la información para actualizar
     * @return DTO de respuesta de la calificación actualizada
     * @throws ExceptionNotFound Si no se encuentra la calificación que se quiere actualizar
     */
    GradeResponseDTO updateGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound;

    /**
     * Encuentra una calificación por id
     * @param id Id de la calificación a encontrar
     * @return Calificación encontrada
     * @throws ExceptionNotFound Si no se encuentra la calificación
     */
    Grade getGradeById(Long id) throws ExceptionNotFound;

    /**
     * Desactiva una calificación
     * @param id Id de la calificación a desactivar
     * @throws ExceptionNotFound Si no se encuentra la calificación
     * @throws ExceptionDeletedData Si la calificación está inactiva
     */
    void deactivateGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData;
    /**
     * Reactiva una calificación
     * @param id Id de la calificación a reactivar
     * @throws ExceptionNotFound Si no se encuentra la calificación
     * @throws ExceptionDeletedData Si la calificación está activa
     */
    void restoreGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData;

}
