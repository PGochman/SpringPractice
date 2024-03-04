package com.practice.practice.service;

import com.practice.practice.dto.request.CalificacionRequestDTO;
import com.practice.practice.dto.response.CalificacionResponseDTO;

import java.util.List;

public interface CalificacionService {
    CalificacionResponseDTO registerCalificacion(CalificacionRequestDTO calificacionRequestDTO);
    List<CalificacionResponseDTO> getCalificacionByStudentId(Long studentId);
    List<CalificacionResponseDTO> getCalificacionByCourseId(Long courseId);
}
