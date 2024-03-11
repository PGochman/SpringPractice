package com.practice.practice.service;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Grade;

import java.util.List;

public interface GradeService {
    GradeResponseDTO registerGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound;
    GradeResponseDTO findGradeById(Long id) throws ExceptionNotFound;
    List<GradeResponseDTO> getGradeByStudentId(Long studentId);
    List<GradeResponseDTO> getGradeByCourseId(Long courseId);
    List<GradeResponseDTO> getAllGrades();
    GradeResponseDTO updateGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound;
    Grade getGradeById(Long id) throws ExceptionNotFound;
    void deactivateGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData;
    void restoreGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData;

}
