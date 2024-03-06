package com.practice.practice.service;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Professor;

public interface ProfessorService {
    ProfessorResponseDTO createProfesor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;
    ProfessorResponseDTO asignProfesorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound;
    Professor findProfesorById(Long profesorId) throws ExceptionNotFound;
}
