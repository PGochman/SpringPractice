package com.practice.practice.controller;

import com.practice.practice.dto.request.CursoRequestDTO;
import com.practice.practice.dto.response.CursoResponseDTO;
import com.practice.practice.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/create")
    public ResponseEntity<CursoResponseDTO> createCurso(@RequestBody CursoRequestDTO cursoRequestDTO){
        CursoResponseDTO cursoResponseDTO = cursoService.createCurso(cursoRequestDTO);
        return ResponseEntity.ok(cursoResponseDTO);
    }
}
