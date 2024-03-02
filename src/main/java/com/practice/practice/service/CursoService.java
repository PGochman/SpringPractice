package com.practice.practice.service;

import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.model.Curso;

public interface CursoService {
    CursoResponseDTO createCurso(CursoRequestDTO cursoRequestDTO);
    Curso findCourseById(Long id);
}
