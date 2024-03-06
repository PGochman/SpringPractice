package com.practice.practice.service;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDTO createAlumno(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    Student findStudentById(Long studentId) throws ExceptionNotFound;
    StudentResponseDTO asignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound;
    List<Student> getAllStudentsByIds(List<Long> studentsIds) throws ExceptionNotFound;
    List<StudentResponseDTO> getAllStudentsByCourseId(Long id) throws ExceptionNotFound;
}
