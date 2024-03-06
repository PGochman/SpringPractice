package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.GradeMapper;
import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import com.practice.practice.model.Grade;
import com.practice.practice.repository.GradeRepository;
import com.practice.practice.service.StudentService;
import com.practice.practice.service.GradeService;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImplementation implements GradeService {
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;
    private final CourseService courseService;
    private final StudentService studentService;

    public GradeServiceImplementation(GradeRepository gradeRepository, GradeMapper gradeMapper, CourseService courseService, StudentService studentService) {
        this.gradeRepository = gradeRepository;
        this.gradeMapper = gradeMapper;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public GradeResponseDTO registerCalificacion(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        Grade objGrade = gradeMapper.requestToCalificacion(gradeRequestDTO);
        Student student = studentService.findStudentById(gradeRequestDTO.getStudentId());
        Course course = courseService.findCourseById(gradeRequestDTO.getCourseId());
        objGrade.setStudent(student);
        objGrade.setCourse(course);
        gradeRepository.save(objGrade);
        return gradeMapper.calificacionToResponse(objGrade);
    }

    @Override
    public List<GradeResponseDTO> getCalificacionByStudentId(Long studentId){
        List<Grade> grades = gradeRepository.findAllByStudentId(studentId);
        return gradeMapper.calificacionListToResponseList(grades);
    }

    @Override
    public  List<GradeResponseDTO> getCalificacionByCourseId(Long courseId){
        List<Grade> grades = gradeRepository.findAllByCourseId(courseId);
        return gradeMapper.calificacionListToResponseList(grades);
    }
}
