package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.CalificacionMapper;
import com.practice.practice.dto.request.CalificacionRequestDTO;
import com.practice.practice.dto.response.CalificacionResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Alumno;
import com.practice.practice.model.Calificacion;
import com.practice.practice.model.Curso;
import com.practice.practice.repository.CalificacionRepository;
import com.practice.practice.service.AlumnoService;
import com.practice.practice.service.CalificacionService;
import com.practice.practice.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalificacionServiceImplementation implements CalificacionService {
    private final CalificacionRepository calificacionRepository;
    private final CalificacionMapper calificacionMapper;
    private final CursoService cursoService;
    private final AlumnoService alumnoService;

    public CalificacionServiceImplementation(CalificacionRepository calificacionRepository, CalificacionMapper calificacionMapper, CursoService cursoService, AlumnoService alumnoService) {
        this.calificacionRepository = calificacionRepository;
        this.calificacionMapper = calificacionMapper;
        this.cursoService = cursoService;
        this.alumnoService = alumnoService;
    }

    @Override
    public CalificacionResponseDTO registerCalificacion(CalificacionRequestDTO calificacionRequestDTO) throws ExceptionNotFound {
        Calificacion objCalificacion = calificacionMapper.requestToCalificacion(calificacionRequestDTO);
        Alumno student = alumnoService.findStudentById(calificacionRequestDTO.getStudentId());
        Curso course = cursoService.findCourseById(calificacionRequestDTO.getCourseId());
        objCalificacion.setStudent(student);
        if(student != null && course.getId() != null){
            objCalificacion.setCourse(course);
        }
        calificacionRepository.save(objCalificacion);
        return calificacionMapper.calificacionToResponse(objCalificacion);
    }

    @Override
    public List<CalificacionResponseDTO> getCalificacionByStudentId(Long studentId){
        List<Calificacion> califications = calificacionRepository.findAllByStudentId(studentId);
        return calificacionMapper.calificacionListToResponseList(califications);
    }

    @Override
    public  List<CalificacionResponseDTO> getCalificacionByCourseId(Long courseId){
        List<Calificacion> califications = calificacionRepository.findAllByCourseId(courseId);
        return calificacionMapper.calificacionListToResponseList(califications);
    }
}
