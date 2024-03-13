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

/**
 * Controlador REST para manejar las peticiones relacionadas con los estudiantes
 * Maneja las peticiones hechas al endpoint /student
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * Servicio para los estudiantes
     */
    private final StudentService studentService;
    /**
     * Constructor para el controlador
     * Inicializa el servicio
     * @param studentService Servicio de estudiantes
     */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    /**
     * Creación de estudiante
     * @param studentRequestDTO información necesaria para crear al estudiante
     * @return ResponseEntity con el estudiante creado, o un
     * error en caso de no encontrar los cursos en los que se
     * quiere inscribir al estudiante
     */
    @PostMapping
    public ResponseEntity<ReturnResponse> createStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO){
        try{
            StudentResponseDTO objStudentResponse = studentService.createStudent(studentRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(objStudentResponse));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
    /**
     * Asignar un curso a un estudiante
     * @param studentCourseRequestDTO Información necesaria para la asociación
     * @return ResponseEntity con el estudiante al cual se le asignó
     * el curso, o un error en caso de que no se encuentre el
     * estudiante o el curso que se quieren asociar, que ya estén
     * relacionados o que alguno de los dos se encuentre desactivado
     */
    @PostMapping("/assignCourse")
    public ResponseEntity<ReturnResponse> assignStudentToCourse(@Valid @RequestBody StudentCourseRequestDTO studentCourseRequestDTO){
        try {
        StudentResponseDTO objStudentResponse = studentService.assignStudentToCourse(studentCourseRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(objStudentResponse));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }   catch (ExceptionAlreadyExists | ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
    /**
     * Buscar un estudiante por id
     * @param id id del estudiante a buscar
     * @return ResponseEntity con el estudiante encontrado,
     * o con un error en caso de que no se encuentre
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getStudentById(@PathVariable Long id){
        try{
            StudentResponseDTO objStudent = studentService.findStudentById(id);
            return ResponseEntity.ok(new ReturnResponse(objStudent));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
    /**
     * Buscar todos los estudiantes
     * @return ResponseEntity con todos los estudiantes registrados
     */
    @GetMapping
    public ResponseEntity<ReturnResponse> getAllStudents(){
        List<StudentResponseDTO> objStudents = studentService.findAllStudents();
        return ResponseEntity.ok(new ReturnResponse(objStudents));
    }
    /**
     * Actualizar un profesor
     * @param studentRequestDTO información del estudiante a actualizar
     * @return ResponseEntity con el estudiante actualizado, o
     * con un error en caso de que no se encuentre, o que se
     * quiera actualizar un estudiante desactivado
     */
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
    /**
     * Desactivar un estudiante
     * @param id id del estudiante a desactivar
     * @return ResponseEntity con un mensaje de exito en caso
     * de que se desactive el estudiante, o un error si no se
     * encuentra o si ya esta desactivado
     */
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
    /**
     * Reactivar un estudiante
     * @param id id del estudiante a reactivar
     * @return ResponseEntity con un mensaje de exito en caso
     * de que se reactive el estudiante, o un error si no se
     * encuentra o si ya esta activado
     */
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