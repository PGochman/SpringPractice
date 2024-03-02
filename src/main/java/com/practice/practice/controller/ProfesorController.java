package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfesorRequestDTO;
import com.practice.practice.dto.response.ProfesorResponseDTO;
import com.practice.practice.service.ProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfesorResponseDTO> createProfesor(@RequestBody ProfesorRequestDTO profesorRequestDTO){
        ProfesorResponseDTO profesorResponseDTO = profesorService.createProfesor(profesorRequestDTO);
        return ResponseEntity.ok(profesorResponseDTO);
    }
}
