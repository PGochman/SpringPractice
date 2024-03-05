package com.practice.practice.service;

import com.practice.practice.dto.request.AlumnoCursoRequestDTO;
import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Alumno;

import java.util.List;

public interface AlumnoService {
    AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO) throws ExceptionNotFound;
    Alumno findStudentById(Long studentId) throws ExceptionNotFound;
    AlumnoResponseDTO asignStudentToCourse(AlumnoCursoRequestDTO alumnoCursoRequestDTO) throws ExceptionNotFound;
    List<Alumno> getAllStudentsByIds(List<Long> studentsIds) throws ExceptionNotFound;


}
