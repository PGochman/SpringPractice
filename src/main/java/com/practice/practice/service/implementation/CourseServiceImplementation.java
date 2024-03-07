package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CourseMapper;
import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.repository.CourseRepository;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Course getCourseById(Long id) throws ExceptionNotFound {
        return courseRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("curso", "ID", id.toString()));
    }

    @Override
    public List<Course> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound {
        List<Course> courses = new ArrayList<>();
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
        return courseMapper.cursoToResponse(course);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) throws ExceptionNotFound{
        Course objCourse = getCourseById(id);

        if(!objCourse.getActive()){
            throw new ExceptionDeletedData("El curso con ID: " + id + " se encuentra borrado de la base de datos", id, "Courses");
        }

        objCourse.setCode(courseRequestDTO.getCode());
        objCourse.setName(courseRequestDTO.getName());
        objCourse.setDescription(courseRequestDTO.getDescription());

        courseRepository.save(objCourse);
        return courseMapper.cursoToResponse(objCourse);
    }

    @Override
    public CourseResponseDTO deleteCourse(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Course objCourse = getCourseById(id);
        if(objCourse.getActive()){
            objCourse.setActive(false);
        } else {
            throw new ExceptionDeletedData("Ya esta eliminado el  curso con el ID: " + id, id, "Course");
        }
        return courseMapper.cursoToResponse(objCourse);
    }
}
