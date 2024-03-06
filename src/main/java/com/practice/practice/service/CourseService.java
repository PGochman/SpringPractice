package com.practice.practice.service;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.dto.response.CourseWithoutStudentsResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
    CourseResponseDTO createCurso(CourseRequestDTO courseRequestDTO);
    Course findCourseById(Long id) throws ExceptionNotFound;
    List<Course> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound;
    List<CourseResponseDTO> getAllCourses();
}
