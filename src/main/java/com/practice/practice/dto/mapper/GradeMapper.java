package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.model.Grade;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface GradeMapper {
    Grade requestToCalificacion(GradeRequestDTO gradeRequestDTO);
    GradeResponseDTO calificacionToResponse(Grade grade);
    List<GradeResponseDTO> calificacionListToResponseList(List<Grade> grades);
}