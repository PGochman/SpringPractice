package com.practice.practice.service;

import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;

public interface ProfesorService {
    ProfesorResponseDTO createProfesor(ProfesorRequestDTO profesorRequestDTO);
}
