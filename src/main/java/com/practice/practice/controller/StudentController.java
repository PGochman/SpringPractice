package com.practice.practice.controller;

import com.practice.practice.dto.request.StudentCourseRequestDTO;
import com.practice.practice.dto.request.StudentRequestDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.dto.response.StudentResponseDTO;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
import com.practice.practice.model.Student;
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
    public ResponseEntity<ReturnResponse> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) throws ExceptionNotFound {
        StudentResponseDTO objStudentResponse = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(objStudentResponse));
    }

    @PostMapping("/assignCourse")
    public ResponseEntity<ReturnResponse> assignStudentToCourse(@Valid @RequestBody StudentCourseRequestDTO studentCourseRequestDTO){
        try {
        StudentResponseDTO objStudentResponse = studentService.assignStudentToCourse(studentCourseRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(objStudentResponse));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }   catch (ExceptionAlreadyExists ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getStudentById(@PathVariable Long id){
        try{
            StudentResponseDTO objStudent = studentService.findStudentById(id);
            return ResponseEntity.ok(new ReturnResponse(objStudent));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @GetMapping
    public ResponseEntity<ReturnResponse> getAllStudents(){
        List<StudentResponseDTO> objStudents = studentService.findAllStudents();
        return ResponseEntity.ok(new ReturnResponse(objStudents));
    }

    @PutMapping
    public ResponseEntity<ReturnResponse> updateStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO){
        try{
            StudentResponseDTO objStudent = studentService.updateStudent(studentRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(objStudent));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }  catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deactivateStudent(@PathVariable Long id) {
        try{
            studentService.deactivateStudent(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Estudiante desactivado con exito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restore(@PathVariable Long id) {
        try{
            studentService.restoreStudent(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Estudiante reactivado con exito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
}