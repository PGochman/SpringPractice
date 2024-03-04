package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.ProfesorMapper;
import com.practice.practice.dto.request.ProfesorCursoRequestDTO;
import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.model.Curso;
import com.practice.practice.model.Profesor;
import com.practice.practice.repository.ProfesorRepository;
import com.practice.practice.service.CursoService;
import com.practice.practice.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImplementation implements ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;
    private final CursoService cursoService;

    public ProfesorServiceImplementation(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper, CursoService cursoService) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
        this.cursoService = cursoService;
    }

    @Override
    public ProfesorResponseDTO createProfesor(ProfesorRequestDTO profesorRequestDTO){
        Profesor objProfesor = profesorMapper.requestToProfesor(profesorRequestDTO);
        List<Curso> courses = new ArrayList<>();
        if(profesorRequestDTO.getCoursesId() != null){
            courses = cursoService.getAllCoursesByIds(profesorRequestDTO.getCoursesId());
        }
        objProfesor.setCourses(courses);
        profesorRepository.save(objProfesor);
        return profesorMapper.profesorToResponse(objProfesor);
    }

    @Override
    public ProfesorResponseDTO asignProfesorToCourse(ProfesorCursoRequestDTO profesorCursoRequestDTO){
        Profesor objProfesor = findProfesorById(profesorCursoRequestDTO.getProfesorId());
        Curso objCurso = cursoService.findCourseById(profesorCursoRequestDTO.getCourseId());
        List<Curso> courses = objProfesor.getCourses();
        if(objCurso.getId() != null && objProfesor.getId() != null){
            courses.add(objCurso);
            objProfesor.setCourses(courses);
        }
        profesorRepository.save(objProfesor);
        return profesorMapper.profesorToResponse(objProfesor);
    }

    @Override
    public Profesor findProfesorById(Long profesorId) {
        Profesor objProfesor = new Profesor();
        Optional<Profesor> found = profesorRepository.findById(profesorId);
        if(found.isPresent()){
            objProfesor = found.get();
        }
        return objProfesor;
    }
}
