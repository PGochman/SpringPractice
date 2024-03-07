package com.practice.practice.service;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorResponseDTO createProfesor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;
    ProfessorResponseDTO asignProfesorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound;
    Professor getProfesorById(Long profesorId) throws ExceptionNotFound;
    ProfessorResponseDTO findProfessorByID(Long id) throws ExceptionNotFound;
    List<ProfessorResponseDTO> findAllProfessors();
    ProfessorResponseDTO updateProfessor(Long id, ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;
    ProfessorResponseDTO deleteProfessor(Long id) throws ExceptionNotFound;
    ProfessorResponseDTO findByLastNameAndSpecialty(String lastname, String specialty) throws ExceptionNotFound;
}
