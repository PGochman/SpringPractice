package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfesorCursoRequestDTO;
import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfesorResponseDTO> createProfesor(@Valid @RequestBody ProfesorRequestDTO profesorRequestDTO) throws ExceptionNotFound {
        ProfesorResponseDTO profesorResponseDTO = profesorService.createProfesor(profesorRequestDTO);
        return ResponseEntity.ok(profesorResponseDTO);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<ProfesorResponseDTO>  asignProfesorToCourse(@Valid @RequestBody ProfesorCursoRequestDTO profesorCursoRequestDTO) throws ExceptionNotFound {
        ProfesorResponseDTO profesorResponseDTO = profesorService.asignProfesorToCourse(profesorCursoRequestDTO);
        return ResponseEntity.ok(profesorResponseDTO);
    }
}
