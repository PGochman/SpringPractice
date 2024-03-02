package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.AlumnoMapper;
import com.practice.practice.dto.request.AlumnoCursoRequestDTO;
import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;
import com.practice.practice.repository.AlumnoRepository;
import com.practice.practice.repository.CursoRepository;
import com.practice.practice.service.AlumnoService;
import com.practice.practice.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImplementation implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final CursoService cursoService;
    public AlumnoServiceImplementation(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper, CursoService cursoService){
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
        this.cursoService = cursoService;
    }

    @Override
    public AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO){
        Alumno objAlumno = alumnoMapper.requestToAlumno(alumnoRequestDTO);
        List<Curso> courses = new ArrayList<>();
        for (long id : alumnoRequestDTO.getCoursesId()){
            Curso curso = cursoService.findCourseById(id);
            if(curso.getId() != null){
                courses.add(curso);
            }
        }
        objAlumno.setCourses(courses);
        alumnoRepository.save(objAlumno);
        return alumnoMapper.alumnoToResponse(objAlumno);
    }
    @Override
    public Alumno findStudentById(Long studentId){
        Alumno alumno = new Alumno();
        Optional<Alumno> found = alumnoRepository.findById(studentId);
        if(found.isPresent()){
            alumno = found.get();
        }
        return alumno;
    }

    @Override
    public AlumnoResponseDTO asignStudentToCourse(AlumnoCursoRequestDTO alumnoCursoRequestDTO){
        Alumno objStudent = findStudentById(alumnoCursoRequestDTO.getStudentId());
        Curso objCourse = cursoService.findCourseById(alumnoCursoRequestDTO.getCourseId());
        List<Curso> objStudentCourses = objStudent.getCourses();
        if(objStudent.getId() != null && objCourse.getId() != null){
            objStudentCourses.add(objCourse);
        }
        objStudent.setCourses(objStudentCourses);
        alumnoRepository.save(objStudent);
        return alumnoMapper.alumnoToResponse(objStudent);
    }
}
