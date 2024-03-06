package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.model.Course;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course requestToCurso(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO cursoToResponse(Course course);

    List<CourseResponseDTO> courseListToCourseResponseList (List<Course> courses);
}
