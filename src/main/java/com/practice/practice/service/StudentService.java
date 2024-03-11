package com.practice.practice.service;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Student;

import java.util.List;

public interface StudentService {
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    Student getStudentById(Long studentId) throws ExceptionNotFound;
    StudentResponseDTO findStudentById(Long id) throws ExceptionNotFound;
    StudentResponseDTO assignStudentToCourse(StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound, ExceptionAlreadyExists;
    List<StudentResponseDTO> findAllStudents();
    StudentResponseDTO updateStudent(StudentRequestDTO studentRequestDTO) throws ExceptionNotFound;
    void deactivateStudent(Long id) throws ExceptionNotFound;
    void restoreStudent(Long id) throws ExceptionNotFound;

}
