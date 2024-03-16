package com.practice.practice.service;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Professor;

import java.util.List;
 /**
 * Interfaz para definir los métodos que manejan la lógica de negocio relacionada con los profesores.
 */
public interface ProfessorService {
     /**
      * Crea un profesor, y devuelve su DTO de respuesta
      * @param professorRequestDTO DTO de petición del profesor a crear
      * @return DTO de respuesta del profesor creado
      * @throws ExceptionNotFound Si no se encuentran los cursos que se quieren asociar al profesor
      */
    ProfessorResponseDTO createProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;

     /**
      * Asigna un curso a un profesor
      * @param professorCourseRequestDTO DTO de petición para relacionar un curso y un profesor
      * @return DTO de respuesta del profesor con el nuevo curso asociado
      * @throws ExceptionNotFound Si no se encuentra el profesor o el curso
      * @throws ExceptionAlreadyExists Si el profesor y el curso ya están relacionados
      */
    ProfessorResponseDTO assignProfessorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound, ExceptionAlreadyExists;

     /**
      * Encuentra un profesor por id
      * @param id Id del profesor a buscar
      * @return Profesor encontrado
      * @throws ExceptionNotFound Si no se encuentra el profesor
      */
    Professor getProfessorById(Long id) throws ExceptionNotFound;

     /**
      * Encuentra un profesor por id, y devuelve su DTO de respuesta
      * @param id id del profesor a buscar
      * @return DTO de respuesta del profesor encontrado
      * @throws ExceptionNotFound Si no se encuentra el profesor
      */
    ProfessorResponseDTO findProfessorByID(Long id) throws ExceptionNotFound;

     /**
      * Encuentra todos los profesores
      * @return Lista de DTO de respuesta de los profesores
      */
    List<ProfessorResponseDTO> findAllProfessors();

     /**
      * Actualiza la información de un profesor
      * @param professorRequestDTO DTO de petición de profesor con la información a actualizar
      * @return DTO de respuesta del profesor actualizado
      * @throws ExceptionNotFound Si no se encuentra el profesor que se quiere actualizar
      */
    ProfessorResponseDTO updateProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;

     /**
      * Desactiva un profesor
      * @param id id del profesor a desactivar
      * @throws ExceptionNotFound Si no se encuentra el profesor
      * @throws ExceptionDeletedData Si el profesor ya está inactivo
      */
    void deactivateProfessor(Long id) throws ExceptionNotFound, ExceptionDeletedData;

     /**
      * Encuentra todos los profesores cuyos apellidos y especialidades coincidan parcialmente con los indicados
      * @param lastname Apellido a buscar
      * @param specialty Especialidad a buscar
      * @return Lista de DTO de respuesta de los profesores encontrados
      * @throws ExceptionNotFound Si ningún profesor coincide con los parámetros de búsqueda
      */
    List<ProfessorResponseDTO> findByLastNameAndSpecialty(String lastname, String specialty) throws ExceptionNotFound;

     /**
      * Reactiva un profesor
      * @param id id del profesor a reactivar
      * @throws ExceptionNotFound Si no se encuentra el profesor
      * @throws ExceptionDeletedData Si el profesor ya está activo
      */
    void restoreProfessor(Long id) throws ExceptionNotFound, ExceptionDeletedData;

}
