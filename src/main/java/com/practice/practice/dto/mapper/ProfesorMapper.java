package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.model.Profesor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProfesorMapper {
    Profesor requestToProfesor(ProfesorRequestDTO profesorRequestDTO);
    ProfesorResponseDTO profesorToResponse(Profesor profesor);
}
