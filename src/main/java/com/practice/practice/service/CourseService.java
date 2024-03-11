package com.practice.practice.service;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;

import java.util.List;
import java.util.Set;

public interface CourseService {
    CourseResponseDTO createCurso(CourseRequestDTO courseRequestDTO);
    Course getCourseById(Long id) throws ExceptionNotFound;
    CourseResponseDTO findCourseById(Long id) throws ExceptionNotFound;
    Set<Course> getAllCoursesByIds(Set<Long> coursesIds) throws ExceptionNotFound;
    List<CourseResponseDTO> getAllCourses();
    void updateCourse(CourseRequestDTO courseRequestDTO) throws ExceptionNotFound;
    void deactivateCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData;
    void restoreCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData;
}
