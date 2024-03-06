package com.practice.practice.controller;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<StudentResponseDTO> createAlumno(@Valid @RequestBody StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        StudentResponseDTO objAlumnoResponse = studentService.createAlumno(studentRequestDTO);
        return ResponseEntity.ok(objAlumnoResponse);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<StudentResponseDTO> asignStudentToCourse(@Valid @RequestBody StudentCourseRequestDTO studentCourseRequestDTO) throws ExceptionNotFound {
        StudentResponseDTO objAlumnoResponse = studentService.asignStudentToCourse(studentCourseRequestDTO);
        return  ResponseEntity.ok(objAlumnoResponse);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentsFromCourse (@PathVariable Long id) throws ExceptionNotFound {
        List<StudentResponseDTO> students = studentService.getAllStudentsByCourseId(id);
        return ResponseEntity.ok(students);
    }

}
