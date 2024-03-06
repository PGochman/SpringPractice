package com.practice.practice.dto.mapper;

import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.dto.response.StudentWithoutCourseResponseDTO;
import com.practice.practice.model.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student requestToStudent(StudentRequestDTO studentRequestDTO);
    StudentResponseDTO studentToResponse(Student student);

    List<StudentResponseDTO> studentListToResponseList(List<Student> students);
}
