package com.practice.practice.controller;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCurso(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.createCurso(courseRequestDTO);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        return ResponseEntity.ok(courseResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable Long id) throws ExceptionNotFound {
        CourseResponseDTO courseResponseDTO = courseService.findCourseById(id);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequestDTO courseRequestDTO) throws  ExceptionNotFound{
        CourseResponseDTO courseResponseDTO = courseService.updateCourse(id, courseRequestDTO);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StringResponse> deleteCourse(@PathVariable Long id) throws ExceptionNotFound{
        CourseResponseDTO courseResponseDTO = courseService.deleteCourse(id);
        return ResponseEntity.ok(new StringResponse("Curso eliminado correctamente"));
    }
}
