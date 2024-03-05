package com.practice.practice.service;

import com.practice.practice.dto.request.ProfesorCursoRequestDTO;
import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Profesor;

public interface ProfesorService {
    ProfesorResponseDTO createProfesor(ProfesorRequestDTO profesorRequestDTO) throws ExceptionNotFound;
    ProfesorResponseDTO asignProfesorToCourse(ProfesorCursoRequestDTO profesorCursoRequestDTO) throws ExceptionNotFound;
    Profesor findProfesorById(Long profesorId) throws ExceptionNotFound;
}
