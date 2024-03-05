package com.practice.practice.controller;

import com.practice.practice.dto.request.CalificacionRequestDTO;
import com.practice.practice.dto.response.CalificacionResponseDTO;
import com.practice.practice.service.CalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {
    private final CalificacionService calificacionService;

    public CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }

    @PostMapping("/register")
    public ResponseEntity<CalificacionResponseDTO> registerCalificacion (@Valid @RequestBody CalificacionRequestDTO calificacionRequestDTO){
        System.out.println(calificacionRequestDTO.toString());
        CalificacionResponseDTO calificacionResponseDTO = calificacionService.registerCalificacion(calificacionRequestDTO);
        return ResponseEntity.ok(calificacionResponseDTO);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<CalificacionResponseDTO>> getCalificacionByStudentId(@Valid @PathVariable Long id){
        List<CalificacionResponseDTO> calificacionList = calificacionService.getCalificacionByStudentId(id);
        return ResponseEntity.ok(calificacionList);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<CalificacionResponseDTO>> getCalificacionByCourseId(@Valid @PathVariable Long id){
        List<CalificacionResponseDTO> calificacionList = calificacionService.getCalificacionByCourseId(id);
        return ResponseEntity.ok(calificacionList);
    }
}
