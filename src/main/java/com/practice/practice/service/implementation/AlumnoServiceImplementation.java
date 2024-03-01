package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.AlumnoMapper;
import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.model.Alumno;
import com.practice.practice.model.Curso;
import com.practice.practice.repository.AlumnoRepository;
import com.practice.practice.repository.CursoRepository;
import com.practice.practice.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImplementation implements AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final CursoRepository cursoRepository;

    public AlumnoServiceImplementation(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper, CursoRepository cursoRepository){
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO){
        Alumno objAlumno = alumnoMapper.requestToAlumno(alumnoRequestDTO);
        List<Curso> courses = new ArrayList<>();
        for (long id : alumnoRequestDTO.getCoursesId()){
            Optional<Curso> found = cursoRepository.findById(id);
            if(found.isPresent()) {
                courses.add(found.get());
            }
        }
        objAlumno.setCourses(courses);
        alumnoRepository.save(objAlumno);
        return alumnoMapper.alumnoToResponse(objAlumno);
    }
}
