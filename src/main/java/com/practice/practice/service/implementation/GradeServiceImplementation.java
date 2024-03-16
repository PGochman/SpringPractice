package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.GradeMapper;
import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionUnavailableConnection;
import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import com.practice.practice.model.Grade;
import com.practice.practice.repository.GradeRepository;
import com.practice.practice.service.StudentService;
import com.practice.practice.service.GradeService;
import com.practice.practice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Implementación de la interfaz GradeService que proporciona lógica de negocio para las calificaciones.
 */
@Service
public class GradeServiceImplementation implements GradeService {
    private final GradeRepository gradeRepository;
    private final GradeMapper gradeMapper;
    private final CourseService courseService;
    private final StudentService studentService;

    /**
     * Constructor para la clase GradeServiceImplementation
     * @param gradeRepository Repositorio de calificaciones
     * @param gradeMapper Mapper de calificaciones
     * @param courseService Servicio de cursos
     * @param studentService Servicio de estudiantes
     */

    public GradeServiceImplementation(GradeRepository gradeRepository, GradeMapper gradeMapper, CourseService courseService, StudentService studentService) {
        this.gradeRepository = gradeRepository;
        this.gradeMapper = gradeMapper;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @Override
    public GradeResponseDTO registerGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        Grade objGrade = gradeMapper.requestToGrade(gradeRequestDTO);
        Student student = studentService.getStudentById(gradeRequestDTO.getStudentId());
        Course course = courseService.getCourseById(gradeRequestDTO.getCourseId());

        Set<Long> coursesFromStudent = new HashSet<>();

        for(Course courseFromStudent : student.getCourses() ){
            coursesFromStudent.add(courseFromStudent.getId());
        }

        if(!coursesFromStudent.contains(course.getId())){
            throw new ExceptionUnavailableConnection("El estudiante no cursa la materia a la que se quiere asignar la nota");
        }
        if(!student.getActive()){
            throw new ExceptionDeletedData("El estudiante al que se le quiere calificar esta desactivado",
                    student.getId(), "Student");
        }
        if(!course.getActive()){
            throw new ExceptionDeletedData("El curso al que se le quiere asignar la nota esta desactivado",
                    course.getId(), "Course");
        }

        objGrade.setActive(true);
        objGrade.setStudent(student);
        objGrade.setCourse(course);

        gradeRepository.save(objGrade);
        return gradeMapper.GradeToResponse(objGrade);
    }

    @Override
    public List<GradeResponseDTO> getGradeByStudentId(Long studentId){
        List<Grade> grades = gradeRepository.findAllByStudentId(studentId);
        return gradeMapper.GradeListToResponseList(grades);
    }

    @Override
    public  List<GradeResponseDTO> getGradeByCourseId(Long courseId){
        List<Grade> grades = gradeRepository.findAllByCourseId(courseId);
        return gradeMapper.GradeListToResponseList(grades);
    }

    @Override
    public List<GradeResponseDTO> getAllGrades(){
        List<Grade> grades = gradeRepository.findAll();
        return gradeMapper.GradeListToResponseList(grades);
    }

    @Override
    public GradeResponseDTO updateGrade(GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        if(!getGradeById(gradeRequestDTO.getId()).getActive()){
            throw new ExceptionDeletedData(
                    "La nota con ID: " + gradeRequestDTO.getId() + " no se encuentra activa",
                    gradeRequestDTO.getId(),
                    "Grade");
        }
        Course course = courseService.getCourseById(gradeRequestDTO.getCourseId());
        Student student = studentService.getStudentById(gradeRequestDTO.getStudentId());

        Set<Long> coursesFromStudent = new HashSet<>();

        for(Course courseFromStudent : student.getCourses() ){
            coursesFromStudent.add(courseFromStudent.getId());
        }

        if(!coursesFromStudent.contains(course.getId())){
            throw new ExceptionUnavailableConnection("El estudiante no cursa la materia a la que se quiere asignar la nota");
        }
        if(!student.getActive()){
            throw new ExceptionDeletedData("El estudiante al que se le quiere calificar esta desactivado",
                    student.getId(), "Student");
        }
        if(!course.getActive()){
            throw new ExceptionDeletedData("El curso al que se le quiere asignar la nota esta desactivado",
                    course.getId(), "Course");
        }

        Grade objGrade = gradeMapper.requestToGrade(gradeRequestDTO);
        objGrade.setActive(true);
        objGrade.setStudent(student);
        objGrade.setCourse(course);

        gradeRepository.save(objGrade);
        return gradeMapper.GradeToResponse(objGrade);
    }

    @Override
    public Grade getGradeById(Long id) throws ExceptionNotFound{
        return gradeRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("Calificacion", "ID", id.toString()));
    }

    @Override
    public GradeResponseDTO findGradeById(Long id) throws ExceptionNotFound{
        Grade grade = getGradeById(id);
        return gradeMapper.GradeToResponse(grade);
    }

    @Override
    public void deactivateGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Grade objGrade = getGradeById(id);
        if(!objGrade.getActive()){
            throw new ExceptionDeletedData("Ya esta eliminado la nota con el ID: " + id, id, "Grade");
        }
        objGrade.setActive(false);
        gradeRepository.save(objGrade);
    }
    @Override
    public void restoreGrade(Long id) throws ExceptionNotFound, ExceptionDeletedData{
        Grade objGrade = getGradeById(id);
        if(objGrade.getActive()){
            throw new ExceptionDeletedData("Ya esta eliminado la nota con el ID: " + id, id, "Grade");
        }
        if(!objGrade.getCourse().getActive()){
            throw new ExceptionDeletedData("No se puede restaurar la nota porque su curso esta inactivo", id, "Grade");
        }
        if(!objGrade.getStudent().getActive()){
            throw new ExceptionDeletedData("No se puede restaurar la nota porque su estudiante esta inactivo", id, "Grade");
        }
        objGrade.setActive(true);
        gradeRepository.save(objGrade);
    }
}
