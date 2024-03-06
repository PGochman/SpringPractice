package com.practice.practice.controller;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.model.Student;
import com.practice.practice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<CourseResponseDTO> createCurso(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.createCurso(courseRequestDTO);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        return ResponseEntity.ok(courseResponseDTOS);
    }
}
