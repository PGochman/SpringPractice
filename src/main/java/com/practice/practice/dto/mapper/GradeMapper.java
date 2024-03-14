package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.model.Grade;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Interfaz para mapear entre objetos de tipo Grade y sus DTO de petición y respuesta
 * Utiliza MapStruct con la configuración de componente de Spring.
 */
@Component
@Mapper(componentModel = "spring")
public interface GradeMapper {
    /**
     * Convierte un objeto de tipo GradeRequestDTO a uno de tipo Grade
     * @param gradeRequestDTO objeto de GradeRequestDTO a convertir
     * @return objeto Grade convertido del GradeRequestDTO
     */
    Grade requestToGrade(GradeRequestDTO gradeRequestDTO);
    /**
     * Convierte un objeto de tipo Grade a uno de GradeResponseDTO
     * @param grade objeto de Grade a convertir
     * @return objeto GradeResponseDTO convertido del Grade
     */
    GradeResponseDTO GradeToResponse(Grade grade);
    /**
     * Convierte una lista de objetos de Grade a una de GradeResponseDTO
     * @param grades Lista de objetos Grade a convertir
     * @return lista de objetos GradeResponseDTO convertido
     */
    List<GradeResponseDTO> GradeListToResponseList(List<Grade> grades);
}
