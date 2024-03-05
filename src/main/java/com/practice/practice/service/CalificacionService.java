package com.practice.practice.service;

import com.practice.practice.dto.request.CalificacionRequestDTO;
import com.practice.practice.dto.response.CalificacionResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;

import java.util.List;

public interface CalificacionService {
    CalificacionResponseDTO registerCalificacion(CalificacionRequestDTO calificacionRequestDTO) throws ExceptionNotFound;
    List<CalificacionResponseDTO> getCalificacionByStudentId(Long studentId);
    List<CalificacionResponseDTO> getCalificacionByCourseId(Long courseId);
}
