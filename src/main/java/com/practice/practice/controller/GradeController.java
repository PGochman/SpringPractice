package com.practice.practice.controller;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
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
    public ResponseEntity<ReturnResponse> registerGrade (@Valid @RequestBody GradeRequestDTO gradeRequestDTO) {
        try{
            GradeResponseDTO gradeResponseDTO = gradeService.registerGrade(gradeRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(gradeResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getGradeById(@Valid @PathVariable Long id){
        try{
            GradeResponseDTO grade = gradeService.findGradeById(id);
            return ResponseEntity.ok(new ReturnResponse(grade));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.ok(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<ReturnResponse> getGradeByStudentId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByStudentId(id);
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<ReturnResponse> getGradeByCourseId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByCourseId(id);
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }

    @GetMapping
    public ResponseEntity<ReturnResponse> getAllGrades(){
        List<GradeResponseDTO> gradeList = gradeService.getAllGrades();
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }

    @PutMapping
    public ResponseEntity<ReturnResponse> updateGrade(@Valid @RequestBody GradeRequestDTO gradeRequestDTO){
        try{
            GradeResponseDTO objGrade = gradeService.updateGrade(gradeRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(objGrade));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }

    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deactivateGrade(@PathVariable Long id){
        try{
            gradeService.deactivateGrade(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Nota desactivada con éxito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restoreGrade(@PathVariable Long id){
        try{
            gradeService.restoreGrade(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Nota reactivada con éxito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
}
