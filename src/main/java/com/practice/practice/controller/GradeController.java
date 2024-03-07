package com.practice.practice.controller;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Grade;
import com.practice.practice.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public ResponseEntity<GradeResponseDTO> registerGrade (@Valid @RequestBody GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        GradeResponseDTO gradeResponseDTO = gradeService.registerGrade(gradeRequestDTO);
        return ResponseEntity.ok(gradeResponseDTO);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<GradeResponseDTO>> getGradeByStudentId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByStudentId(id);
        return ResponseEntity.ok(gradeList);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<GradeResponseDTO>> getGradeByCourseId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByCourseId(id);
        return ResponseEntity.ok(gradeList);
    }

    @GetMapping
    public ResponseEntity<List<GradeResponseDTO>> getAllGrades(){
        List<GradeResponseDTO> gradeList = gradeService.getAllGrades();
        return ResponseEntity.ok(gradeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeResponseDTO> updateGrade(@PathVariable Long id, @Valid @RequestBody GradeRequestDTO gradeRequestDTO) throws ExceptionNotFound {
        GradeResponseDTO objGrade = gradeService.updateGrade(id, gradeRequestDTO);
        return ResponseEntity.ok(objGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GradeResponseDTO> deleteGrade(@PathVariable Long id) throws ExceptionNotFound {
        GradeResponseDTO objGrade = gradeService.deleteGrade(id);
        return ResponseEntity.ok(objGrade);
    }
}
