package com.practice.practice.controller;

import com.practice.practice.dto.request.CourseRequestDTO;
import com.practice.practice.dto.response.CourseResponseDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
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
    public ResponseEntity<ReturnResponse> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.createCurso(courseRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(courseResponseDTO));
    }

    @GetMapping
    public ResponseEntity<ReturnResponse> getAllCourses(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        return ResponseEntity.ok(new ReturnResponse(courseResponseDTOS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getCourseById(@PathVariable Long id) {
        try{
            CourseResponseDTO courseResponseDTO = courseService.findCourseById(id);
            return ResponseEntity.ok(new ReturnResponse(courseResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping
    public ResponseEntity<ReturnResponse> updateCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        try{
            courseService.updateCourse(courseRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Curso actualizado con éxito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deleteCourse(@PathVariable Long id){
        try{
            courseService.deactivateCourse(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Curso desactivado correctamente")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }

    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restoreCourse(@PathVariable Long id){
        try{
            courseService.restoreCourse(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Curso reactivado correctamente")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }

    }
}
