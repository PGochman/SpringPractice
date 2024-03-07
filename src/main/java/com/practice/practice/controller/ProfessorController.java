package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> createProfesor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.createProfesor(professorRequestDTO);
        return ResponseEntity.ok(professorResponseDTO);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<ProfessorResponseDTO>  asignProfesorToCourse(@Valid @RequestBody ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.asignProfesorToCourse(professorCourseRequestDTO);
        return ResponseEntity.ok(professorResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> getAllProfessors(){
        List<ProfessorResponseDTO> professorResponseDTOList = professorService.findAllProfessors();
        return ResponseEntity.ok(professorResponseDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorById(@PathVariable Long id) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.findProfessorByID(id);
        return ResponseEntity.ok(professorResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> updateProfessor(@PathVariable Long id, @Valid @RequestBody ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.updateProfessor(id, professorRequestDTO);
        return ResponseEntity.ok(professorResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> deleteProfessor(@PathVariable Long id) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.deleteProfessor(id);
        return ResponseEntity.ok(professorResponseDTO);
    }

    @GetMapping("/find")
    public ResponseEntity<ProfessorResponseDTO> findProfessorByLastNameAndSpecialty(@RequestParam String lastname, String specialty) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.findByLastNameAndSpecialty(lastname, specialty);
        return ResponseEntity.ok(professorResponseDTO);
    }
}
