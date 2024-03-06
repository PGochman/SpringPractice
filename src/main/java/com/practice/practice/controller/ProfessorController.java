package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProfessorResponseDTO> createProfesor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.createProfesor(professorRequestDTO);
        return ResponseEntity.ok(professorResponseDTO);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<ProfessorResponseDTO>  asignProfesorToCourse(@Valid @RequestBody ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.asignProfesorToCourse(professorCourseRequestDTO);
        return ResponseEntity.ok(professorResponseDTO);
    }
}
