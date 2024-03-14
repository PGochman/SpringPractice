package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.dto.response.StudentWithoutCourseResponseDTO;
import com.practice.practice.model.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Interfaz para mapear entre objetos de tipo Student y sus DTO de petición y respuesta
 * Utiliza MapStruct con la configuración de componente de Spring.
 */
@Component
@Mapper(componentModel = "spring")
public interface StudentMapper {
    /**
     * Convierte un objeto de tipo StudentRequestDTO a uno de tipo Student
     * @param studentRequestDTO objeto de StudentRequestDTO a convertir
     * @return objeto Student convertido del StudentRequestDTO
     */
    Student requestToStudent(StudentRequestDTO studentRequestDTO);
    /**
     * Convierte un objeto de tipo Student a uno de StudentResponseDTO
     * @param student objeto de Student a convertir
     * @return objeto StudentResponseDTO convertido del Student
     */
    StudentResponseDTO studentToResponse(Student student);
    /**
     * Convierte una lista de objetos de Student a una de StudentResponseDTO
     * @param students Lista de objetos Student a convertir
     * @return lista de objetos StudentResponseDTO convertido
     */
    List<StudentResponseDTO> studentListToResponseList(List<Student> students);
}
