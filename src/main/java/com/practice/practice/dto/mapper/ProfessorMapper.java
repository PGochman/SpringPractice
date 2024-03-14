package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.model.Professor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Interfaz para mapear entre objetos de tipo Professor y sus DTO de petición y respuesta
 * Utiliza MapStruct con la configuración de componente de Spring.
 */
@Component
@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    /**
     * Convierte un objeto de tipo ProfessorRequestDTO a uno de tipo Professor
     * @param professorRequestDTO objeto de ProfessorRequestDTO a convertir
     * @return objeto Professor convertido del ProfessorRequestDTO
     */
    Professor requestToProfessor(ProfessorRequestDTO professorRequestDTO);
    /**
     * Convierte un objeto de tipo Professor a uno de ProfessorResponseDTO
     * @param professor objeto de Professor a convertir
     * @return objeto ProfessorResponseDTO convertido del Professor
     */
    ProfessorResponseDTO professorToResponse(Professor professor);
    /**
     * Convierte una lista de objetos de Professor a una de ProfessorResponseDTO
     * @param professorList Lista de objetos Professor a convertir
     * @return lista de objetos ProfessorResponseDTO convertido
     */
    List<ProfessorResponseDTO> professorListToResponseList(List<Professor> professorList);
}
