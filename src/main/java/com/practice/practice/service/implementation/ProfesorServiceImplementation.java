package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.ProfesorMapper;
import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.model.Profesor;
import com.practice.practice.repository.ProfesorRepository;
import com.practice.practice.service.ProfesorService;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImplementation implements ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final ProfesorMapper profesorMapper;

    public ProfesorServiceImplementation(ProfesorRepository profesorRepository, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.profesorMapper = profesorMapper;
    }

    @Override
    public ProfesorResponseDTO createProfesor(ProfesorRequestDTO profesorRequestDTO){
        Profesor objProfesor = profesorMapper.requestToProfesor(profesorRequestDTO);
        profesorRepository.save(objProfesor);
        return profesorMapper.profesorToResponse(objProfesor);
    }
}
