package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CourseMapper;
import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import com.practice.practice.repository.CourseRepository;
import com.practice.practice.service.CourseService;
import com.practice.practice.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public CourseResponseDTO createCurso(CourseRequestDTO courseRequestDTO){
        Course objCourse = courseMapper.requestToCurso(courseRequestDTO);
        courseRepository.save(objCourse);
        return courseMapper.cursoToResponse(objCourse);
    }

    @Override
    public Course findCourseById(Long id) throws ExceptionNotFound {
        return courseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("curso", "ID", id.toString()));
    }

    @Override
    public List<Course> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound {
        List<Course> courses = new ArrayList<>();
        for (Long id: coursesIds){
            Course course = findCourseById(id);
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
}
