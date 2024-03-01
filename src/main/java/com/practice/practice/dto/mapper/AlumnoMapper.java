package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.model.Alumno;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    Alumno requestToAlumno(AlumnoRequestDTO alumnoRequestDTO);
    AlumnoResponseDTO alumnoToResponse(Alumno alumno);
}
