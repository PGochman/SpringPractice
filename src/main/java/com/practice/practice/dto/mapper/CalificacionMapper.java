package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.CalificacionRequestDTO;
import com.practice.practice.dto.response.CalificacionResponseDTO;
import com.practice.practice.model.Calificacion;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CalificacionMapper {
    Calificacion requestToCalificacion(CalificacionRequestDTO calificacionRequestDTO);
    CalificacionResponseDTO calificacionToResponse(Calificacion calificacion);
    List<CalificacionResponseDTO> calificacionListToResponseList(List<Calificacion> califications);
}
