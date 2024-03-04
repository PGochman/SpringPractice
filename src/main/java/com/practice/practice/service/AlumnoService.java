package com.practice.practice.service;

import com.practice.practice.dto.request.AlumnoCursoRequestDTO;
import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.model.Alumno;

import java.util.List;

public interface AlumnoService {
    AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO);
    Alumno findStudentById(Long studentId);
    AlumnoResponseDTO asignStudentToCourse(AlumnoCursoRequestDTO alumnoCursoRequestDTO);
    List<Alumno> getAllStudentsByIds(List<Long> studentsIds);


}
