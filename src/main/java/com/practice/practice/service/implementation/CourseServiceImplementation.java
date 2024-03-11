package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CourseMapper;
import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Grade;
import com.practice.practice.repository.CourseRepository;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    public CourseServiceImplementation(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO){
        Course objCourse = courseMapper.requestToCourse(courseRequestDTO);
        objCourse.setActive(true);
        courseRepository.save(objCourse);
        return courseMapper.courseToResponse(objCourse);
    }

    @Override
    public Course getCourseById(Long id) throws ExceptionNotFound {
        return courseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("curso", "ID", id.toString()));
    }

    @Override
    public Set<Course> getAllCoursesByIds(Set<Long> coursesIds) throws ExceptionNotFound {
        Set<Course> courses = new HashSet<>();
        for (Long id: coursesIds){
            Course course = getCourseById(id);
            if(course.getId() != null){
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses(){
        return courseMapper.courseListToCourseResponseList(courseRepository.findAll());
    }

    @Override
    public CourseResponseDTO findCourseById(Long id) throws ExceptionNotFound{
        Course course = getCourseById(id);
        return courseMapper.courseToResponse(course);
    }

    @Override
    public void updateCourse(CourseRequestDTO courseRequestDTO) throws ExceptionNotFound{
        if(!getCourseById(courseRequestDTO.getId()).getActive()){
            throw new ExceptionDeletedData("El curso con ID: " + courseRequestDTO.getId() + " se encuentra desactivado", courseRequestDTO.getId(), "Courses");
        }

        Course objCourse = courseMapper.requestToCourse(courseRequestDTO);
        objCourse.setActive(true);

        courseRepository.save(objCourse);
    }
    @Override
    public void deactivateCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Course objCourse = getCourseById(id);
        if(!objCourse.getActive()){
            throw new ExceptionDeletedData("Ya esta eliminado el  curso con el ID: " + id, id, "Course");
        }

        Set<Grade> grades = new HashSet<>();
        for(Grade grade : objCourse.getGrades()) {
            grade.setActive(false);
            grades.add(grade);
        }
        objCourse.setGrades(grades);

        objCourse.setActive(false);
        courseRepository.save(objCourse);
    }
    @Override
    public void restoreCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Course objCourse = getCourseById(id);
        if(objCourse.getActive()){
            throw new ExceptionDeletedData("Ya se encuentra activo el curso con el ID: " + id, id, "Course");
        }
        objCourse.setActive(true);
        courseRepository.save(objCourse);
    }
}
