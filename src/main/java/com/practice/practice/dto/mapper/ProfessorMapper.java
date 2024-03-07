package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.model.Professor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    Professor requestToProfesor(ProfessorRequestDTO professorRequestDTO);
    ProfessorResponseDTO profesorToResponse(Professor professor);
    List<ProfessorResponseDTO> professorListToResponseList(List<Professor> professorList);
}
