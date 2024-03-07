package com.practice.practice.service;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDTO createAlumno(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    Student getStudentById(Long studentId) throws ExceptionNotFound;
    StudentResponseDTO findStudentById(Long id) throws ExceptionNotFound;
    StudentResponseDTO asignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound;
    List<StudentResponseDTO> findAllStudents();
    StudentResponseDTO updateStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    StudentResponseDTO deleteStudent(Long id) throws ExceptionNotFound;
}
