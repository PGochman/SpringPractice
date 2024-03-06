package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.ProfessorMapper;
import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Professor;
import com.practice.practice.repository.ProfessorRepository;
import com.practice.practice.service.CourseService;
import com.practice.practice.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProfessorServiceImplementation implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final CourseService courseService;

    public ProfessorServiceImplementation(ProfessorRepository professorRepository, ProfessorMapper professorMapper, CourseService courseService) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.courseService = courseService;
    }

    @Override
    public ProfessorResponseDTO createProfesor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = professorMapper.requestToProfesor(professorRequestDTO);
        List<Course> courses = new ArrayList<>();
        if(professorRequestDTO.getCoursesId() != null){
            courses = courseService.getAllCoursesByIds(professorRequestDTO.getCoursesId());
        }
        objProfessor.setCourses(courses);
        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public ProfessorResponseDTO asignProfesorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = findProfesorById(professorCourseRequestDTO.getProfesorId());
        Course objCourse = courseService.findCourseById(professorCourseRequestDTO.getCourseId());
        List<Course> courses = objProfessor.getCourses();
        courses.add(objCourse);
        objProfessor.setCourses(courses);
        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public Professor findProfesorById(Long profesorId) throws ExceptionNotFound {
        return professorRepository.findById(profesorId).orElseThrow(() -> new ExceptionNotFound("profesor", "ID", profesorId.toString()));
    }
}
