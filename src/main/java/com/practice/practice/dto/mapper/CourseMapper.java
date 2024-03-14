package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.model.Course;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Interfaz para mapear entre objetos de tipo Course y sus DTO de petición y respuesta
 * Utiliza MapStruct con la configuración de componente de Spring.
 */
@Component
@Mapper(componentModel = "spring")
public interface CourseMapper {
    /**
     * Convierte un objeto de tipo CourseRequestDTO a uno de tipo Course
     * @param courseRequestDTO objeto de CourseRequestDTO a convertir
     * @return objeto Course convertido del CourseRequestDTO
     */
    Course requestToCourse(CourseRequestDTO courseRequestDTO);
    /**
     * Convierte un objeto de tipo Course a uno de CourseResponseDTO
     * @param course objeto de Course a convertir
     * @return objeto CourseResponseDTO convertido del Course
     */
    CourseResponseDTO courseToResponse(Course course);
    /**
     * Convierte una lista de objetos de Course a una de CourseResponseDTO
     * @param courses Lista de objetos Course a convertir
     * @return lista de objetos CourseResponseDTO convertido
     */
    List<CourseResponseDTO> courseListToCourseResponseList (List<Course> courses);
}
