package com.practice.practice.service;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;

import java.util.List;

public interface CourseService {
    CourseResponseDTO createCurso(CourseRequestDTO courseRequestDTO);
    Course getCourseById(Long id) throws ExceptionNotFound;
    CourseResponseDTO findCourseById(Long id) throws ExceptionNotFound;
    List<Course> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound;
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) throws ExceptionNotFound;
    CourseResponseDTO deleteCourse(Long id) throws ExceptionNotFound;

}
