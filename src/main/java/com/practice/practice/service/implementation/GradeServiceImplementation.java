package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.GradeMapper;
import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
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
    public GradeResponseDTO registerGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        Grade objGrade = gradeMapper.requestToCalificacion(gradeRequestDTO);
        Student student = studentService.getStudentById(gradeRequestDTO.getStudentId());
        Course course = courseService.getCourseById(gradeRequestDTO.getCourseId());
        objGrade.setStudent(student);
        objGrade.setCourse(course);
        gradeRepository.save(objGrade);
        return gradeMapper.calificacionToResponse(objGrade);
    }

    @Override
    public List<GradeResponseDTO> getGradeByStudentId(Long studentId){
        List<Grade> grades = gradeRepository.findAllByStudentId(studentId);
        return gradeMapper.calificacionListToResponseList(grades);
    }

    @Override
    public  List<GradeResponseDTO> getGradeByCourseId(Long courseId){
        List<Grade> grades = gradeRepository.findAllByCourseId(courseId);
        return gradeMapper.calificacionListToResponseList(grades);
    }

    @Override
    public List<GradeResponseDTO> getAllGrades(){
        List<Grade> grades = gradeRepository.findAll();
        return gradeMapper.calificacionListToResponseList(grades);
    }

    @Override
    public GradeResponseDTO updateGrade(Long id, GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        Grade grade = getGradeById(id);
        Course course = courseService.getCourseById(gradeRequestDTO.getCourseId());
        Student student = studentService.getStudentById(gradeRequestDTO.getStudentId());

        grade.setGrade(gradeRequestDTO.getGrade());
        grade.setCourse(course);
        grade.setStudent(student);
        grade.setEvaluationType(gradeRequestDTO.getEvaluationType());

        gradeRepository.save(grade);
        return gradeMapper.calificacionToResponse(grade);
    }

    @Override
    public Grade getGradeById(Long id) throws ExceptionNotFound{
        return gradeRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Calificacion", "ID", id.toString()));
    }

    @Override
    public GradeResponseDTO deleteGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Grade objGrade = getGradeById(id);
        if(objGrade.getActive()){
            objGrade.setActive(false);
        } else {
            throw new ExceptionDeletedData("Ya esta eliminado la nota con el ID: " + id, id, "Grade");
        }
        return gradeMapper.calificacionToResponse(objGrade);
    }
}
