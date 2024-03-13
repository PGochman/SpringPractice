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

/**
 * Controlador REST para manejar las peticiones relacionadas con los cursos
 * Maneja las peticiones hechas al endpoint /course
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * Servicio para el curso
     * @see CourseService
     */
    private final CourseService courseService;
    /**
     * Constructor para el controlador
     * Inicializa el servicio que va a utilizar
     * @param courseService servicio del curso
     */
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * Crea un nuevo curso
     * @param courseRequestDTO información necesaria para crear el curso
     * @return ResponseEntity con el curso nuevo creado
     */
    @PostMapping
    public ResponseEntity<ReturnResponse> createCourse(@Valid @RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = courseService.createCourse(courseRequestDTO);
        return ResponseEntity.ok(new ReturnResponse(courseResponseDTO));
    }

    /**
     * Busca todos los cursos registrados
     * @return ResponseEntity con todos los cursos registrados
     */
    @GetMapping
    public ResponseEntity<ReturnResponse> getAllCourses(){
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        return ResponseEntity.ok(new ReturnResponse(courseResponseDTOS));
    }

    /**
     * Busca un curso por id
     * @param id id del curso a buscar
     * @return ResponseEntity con el curso buscado, o con un error en el caso de no encontrarlo
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getCourseById(@PathVariable Long id) {
        try{
            CourseResponseDTO courseResponseDTO = courseService.findCourseById(id);
            return ResponseEntity.ok(new ReturnResponse(courseResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Actualizar un curso
     * @param courseRequestDTO información del curso a actualizar
     * @return ResponseEntity con el curso actualizado, o un
     * error en caso de no encontrar el curso que se quiere
     * actualizar o que se quiera actualizar un curso desactivado
     */
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

    /**
     * Realiza el borrado lógico y desactiva un curso
     * @param id id del curso a desactivar
     * @return Response entity con un mensaje exitoso en caso
     * de que se desactive el curso, o un error si no se
     * encuentra o ya se encontraba desactivado
     */
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

    /**
     * Reactiva un curso que se encontraba desactivado
     * @param id id del curso a reactivar
     * @return ResponseEntity con un mensaje de exito en caso
     * de que se reactive el curso, o un error si no se
     * econtró el curso o ya se encontraba activo
     */
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
