package com.practice.practice.service;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;

import java.util.List;

public interface GradeService {
    GradeResponseDTO registerCalificacion(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound;
    List<GradeResponseDTO> getCalificacionByStudentId(Long studentId);
    List<GradeResponseDTO> getCalificacionByCourseId(Long courseId);
}
