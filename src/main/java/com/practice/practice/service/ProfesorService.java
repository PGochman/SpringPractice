package com.practice.practice.service;

import com.practice.practice.dto.request.ProfesorCursoRequestDTO;
import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.model.Profesor;

public interface ProfesorService {
    ProfesorResponseDTO createProfesor(ProfesorRequestDTO profesorRequestDTO);
    ProfesorResponseDTO asignProfesorToCourse(ProfesorCursoRequestDTO profesorCursoRequestDTO);
    Profesor findProfesorById(Long profesorId);
}
