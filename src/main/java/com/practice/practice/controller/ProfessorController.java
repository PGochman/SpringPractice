package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
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
    public ResponseEntity<ReturnResponse> createProfessor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        ProfessorResponseDTO professorResponseDTO = professorService.createProfessor(professorRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<ReturnResponse>  asignProfesorToCourse(@Valid @RequestBody ProfessorCourseRequestDTO professorCourseRequestDTO){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.assignProfessorToCourse(professorCourseRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping
    public ResponseEntity<ReturnResponse> getAllProfessors(){
        List<ProfessorResponseDTO> professorResponseDTOList = professorService.findAllProfessors();
        return ResponseEntity.ok(new ReturnResponse(professorResponseDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getProfessorById(@PathVariable Long id){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.findProfessorByID(id);
            return ResponseEntity.ok( new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping
    public ResponseEntity<ReturnResponse> updateProfessor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.updateProfessor(professorRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deactivateProfessor(@PathVariable Long id){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.deactivateProfessor(id);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restoreProfessor(@PathVariable Long id){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.restoreProfessor(id);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping("/find")
    public ResponseEntity<ReturnResponse> findProfessorByLastNameAndSpecialty(@RequestParam String lastname, String specialty){
        try{
            List<ProfessorResponseDTO> professorResponseDTO = professorService.findByLastNameAndSpecialty(lastname, specialty);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        }   catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
}
