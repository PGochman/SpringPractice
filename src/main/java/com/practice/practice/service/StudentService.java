package com.practice.practice.service;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Student;

import java.util.List;
/**
 * Interfaz para definir los métodos que manejan la lógica de negocio relacionada con los estudiantes.
 */
public interface StudentService {
    /**
     * Crea un estudiante, y devuelve su DTO de respuesta
     * @param studentRequestDTO DTO de petición del estudiante a crear
     * @return DTO de respuesta del estudiante creado
     * @throws ExceptionNotFound Si no se encuentran los cursos que se quieren asociar al estudiante
     */
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    /**
     * Encuentra un estudiante por id
     * @param studentId Id del estudiante a buscar
     * @return Estudiante encontrado
     * @throws ExceptionNotFound Si no se encuentra el estudiante
     */
    Student getStudentById(Long studentId) throws ExceptionNotFound;
    /**
     * Encuentra un estudiante por id, y devuelve su DTO de respuesta
     * @param id id del estudiante a buscar
     * @return DTO de respuesta del estudiante encontrado
     * @throws ExceptionNotFound Si no se encuentra el estudiante
     */
    StudentResponseDTO findStudentById(Long id) throws ExceptionNotFound;
    /**
     * Asigna un curso a un estudiante
     * @param studentCourseRequestDTO DTO de petición para relacionar un curso y un estudiante
     * @return DTO de respuesta del estudiante con el nuevo curso asociado
     * @throws ExceptionNotFound Si no se encuentra el estudiante o el curso
     * @throws ExceptionAlreadyExists Si el estudiante y el curso ya están relacionados
     */
    StudentResponseDTO assignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound, ExceptionAlreadyExists;
    /**
     * Encuentra todos los estudiantes
     * @return Lista de DTO de respuesta de los estudiantes
     */
    List<StudentResponseDTO> findAllStudents();
    /**
     * Actualiza la información de un estudiante
     * @param studentRequestDTO DTO de petición de estudiante con la información a actualizar
     * @return DTO de respuesta del estudiante actualizado
     * @throws ExceptionNotFound Si no se encuentra el estudiante que se quiere actualizar
     */
    StudentResponseDTO updateStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    /**
     * Desactiva un estudiante
     * @param id id del estudiante a desactivar
     * @throws ExceptionNotFound Si no se encuentra el estudiante
     * @throws ExceptionDeletedData Si el estudiante ya está inactivo
     */
    void deactivateStudent(Long id) throws ExceptionNotFound, ExceptionDeletedData;
    /**
     * Reactiva un estudiante
     * @param id id del estudiante a reactivar
     * @throws ExceptionNotFound Si no se encuentra el estudiante
     * @throws ExceptionDeletedData Si el estudiante ya está activo
     */
    void restoreStudent(Long id) throws ExceptionNotFound, ExceptionDeletedData;

}
