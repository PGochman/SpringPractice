package com.practice.practice.controller;

import com.practice.practice.dto.request.AlumnoCursoRequestDTO;
import com.practice.practice.dto.request.AlumnoRequestDTO;
import com.practice.practice.dto.response.AlumnoResponseDTO;
import com.practice.practice.service.AlumnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
    @PostMapping("/create")
    public ResponseEntity<AlumnoResponseDTO> createAlumno(@Valid @RequestBody AlumnoRequestDTO alumnoRequestDTO){
        AlumnoResponseDTO objAlumnoResponse = alumnoService.createAlumno(alumnoRequestDTO);
        return ResponseEntity.ok(objAlumnoResponse);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<AlumnoResponseDTO> asignStudentToCourse(@Valid @RequestBody AlumnoCursoRequestDTO alumnoCursoRequestDTO){
        AlumnoResponseDTO objAlumnoResponse = alumnoService.asignStudentToCourse(alumnoCursoRequestDTO);
        return  ResponseEntity.ok(objAlumnoResponse);
    }

}
