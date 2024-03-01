package com.practice.practice.service;

import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;

public interface AlumnoService {
    AlumnoResponseDTO createAlumno(AlumnoRequestDTO alumnoRequestDTO);
}
