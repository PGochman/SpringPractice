package com.practice.practice.service;

import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Curso;

import java.util.List;

public interface CursoService {
    CursoResponseDTO createCurso(CursoRequestDTO cursoRequestDTO);
    Curso findCourseById(Long id) throws ExceptionNotFound;
    List<Curso> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound;
}
