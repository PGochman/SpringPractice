package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CursoMapper;
import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;
import com.practice.practice.repository.CursoRepository;
import com.practice.practice.service.AlumnoService;
import com.practice.practice.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImplementation implements CursoService {
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;
    public CursoServiceImplementation(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Override
    public CursoResponseDTO createCurso(CursoRequestDTO cursoRequestDTO){
        Curso objCurso = cursoMapper.requestToCurso(cursoRequestDTO);
        cursoRepository.save(objCurso);
        return cursoMapper.cursoToResponse(objCurso);
    }

    @Override
    public Curso findCourseById(Long id) throws ExceptionNotFound {
        return cursoRepository.findById(id).orElseThrow(() -> new ExceptionNotFound("curso", "ID", id.toString()));
    }

    @Override
    public List<Curso> getAllCoursesByIds(List<Long> coursesIds) throws ExceptionNotFound {
        List<Curso> courses = new ArrayList<>();
        for (Long id: coursesIds){
            Curso course = findCourseById(id);
            if(course.getId() != null){
                courses.add(course);
            }
        }
        return courses;
    }
}
