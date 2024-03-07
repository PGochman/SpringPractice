package com.practice.practice.controller;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
import com.practice.practice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createAlumno(@Valid @RequestBody StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        StudentResponseDTO objAlumnoResponse = studentService.createAlumno(studentRequestDTO);
        return ResponseEntity.ok(objAlumnoResponse);
    }

    @PostMapping("/asignCourse")
    public ResponseEntity<ReturnResponse> asignStudentToCourse(@Valid @RequestBody StudentCourseRequestDTO studentCourseRequestDTO){
        try {
        StudentResponseDTO objStudentResponse = studentService.asignStudentToCourse(studentCourseRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(objStudentResponse));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getStudentById(@PathVariable Long id) throws ExceptionNotFound{
        StudentResponseDTO objStudent = studentService.findStudentById(id);
        ReturnResponse response = new ReturnResponse(objStudent);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        List<StudentResponseDTO> objStudents = studentService.findAllStudents();
        return ResponseEntity.ok(objStudents);
    }

    @PutMapping
    public ResponseEntity<StudentResponseDTO> updateStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        StudentResponseDTO objStudent = studentService.updateStudent(studentRequestDTO);
        return ResponseEntity.ok(objStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable Long id) {
        try{
            StudentResponseDTO objStudent = studentService.deleteStudent(id);
            return ResponseEntity.ok(objStudent);
        } catch (Exception ex){
            return ResponseEntity.status(404).body(ex);
        }
    }
}