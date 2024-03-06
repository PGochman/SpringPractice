package com.practice.practice.controller;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calificacion")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/register")
    public ResponseEntity<GradeResponseDTO> registerCalificacion (@Valid @RequestBody GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        GradeResponseDTO gradeResponseDTO = gradeService.registerCalificacion(gradeRequestDTO);
        return ResponseEntity.ok(gradeResponseDTO);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<GradeResponseDTO>> getCalificacionByStudentId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> calificacionList = gradeService.getCalificacionByStudentId(id);
        return ResponseEntity.ok(calificacionList);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<GradeResponseDTO>> getCalificacionByCourseId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> calificacionList = gradeService.getCalificacionByCourseId(id);
        return ResponseEntity.ok(calificacionList);
    }
}
