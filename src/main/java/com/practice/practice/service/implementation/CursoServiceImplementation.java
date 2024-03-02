package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CursoMapper;
import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;
import com.practice.practice.repository.CursoRepository;
import com.practice.practice.service.AlumnoService;
import com.practice.practice.service.CursoService;
import org.springframework.stereotype.Service;

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
    public Curso findCourseById(Long id){
        Curso objCurso = new Curso();
        Optional<Curso> found = cursoRepository.findById(id);
        if(found.isPresent()) {
            objCurso = found.get();
        }
        return objCurso;
    }
}
