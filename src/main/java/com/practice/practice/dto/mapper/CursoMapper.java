package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.model.Curso;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CursoMapper {
    Curso requestToCurso(CursoRequestDTO cursoRequestDTO);
    CursoResponseDTO cursoToResponse(Curso curso);
}
