package com.practice.practice.controller;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.exception.ExceptionAlreadyExists;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
import com.practice.practice.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador REST para manejar las peticiones relacionadas con los profesores
 * Maneja las peticiones hechas al endpoint /professor
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    /**
     * Servicio para los profesores
     */
    private final ProfessorService professorService;
    /**
     * Constructor para el controlador
     * Inicializa el servicio
     * @param professorService Servicio de profesores
     */
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    /**
     * Creación de profesor
     * @param professorRequestDTO información necesaria para crear al profesor
     * @return ResponseEntity con el profesor creado, o un
     * error en caso de no encontrar los cursos a los que se
     * quiere asociar al profesor
     */
    @PostMapping
    public ResponseEntity<ReturnResponse> createProfessor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.createProfessor(professorRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        } catch(ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Asignar un curso a un profesor
     * @param professorCourseRequestDTO Información necesaria para la asociación
     * @return ResponseEntity con el profesor al cual se le asignó
     * el curso, o un error en caso de que no se encuentre el
     * profesor o el curso que se quieren asociar, que ya estén
     * relacionados o que alguno de los dos se encuentre desactivado
     */
    @PostMapping("/assignCourse")
    public ResponseEntity<ReturnResponse> assignProfessorToCourse(@Valid @RequestBody ProfessorCourseRequestDTO professorCourseRequestDTO){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.assignProfessorToCourse(professorCourseRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionAlreadyExists | ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Buscar todos los profesores
     * @return ResponseEntity con todos los profesores registrados
     */
    @GetMapping
    public ResponseEntity<ReturnResponse> getAllProfessors(){
        List<ProfessorResponseDTO> professorResponseDTOList = professorService.findAllProfessors();
        return ResponseEntity.ok(new ReturnResponse(professorResponseDTOList));
    }

    /**
     * Buscar un profesor por id
     * @param id id del profesor a buscar
     * @return ResponseEntity con el profesor encontrado,
     * o con un error en caso de que no se encuentre
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getProfessorById(@PathVariable Long id){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.findProfessorByID(id);
            return ResponseEntity.ok( new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Actualizar un profesor
     * @param professorRequestDTO información del profesor a actualizar
     * @return ResponseEntity con el profesor actualizado, o
     * con un error en caso de que no se encuentre, o que se
     * quiera actualizar un profesor desactivado
     */
    @PutMapping
    public ResponseEntity<ReturnResponse> updateProfessor(@Valid @RequestBody ProfessorRequestDTO professorRequestDTO){
        try{
            ProfessorResponseDTO professorResponseDTO = professorService.updateProfessor(professorRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Desactivar un profesor
     * @param id id del profesor a desactivar
     * @return ResponseEntity con un mensaje de exito en caso
     * de que se desactive el profesor, o un error si no se
     * encuentra o si ya esta desactivado
     */
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deactivateProfessor(@PathVariable Long id){
        try{
            professorService.deactivateProfessor(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Profesor desactivado con exito")));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
    /**
     * Reactivar un profesor
     * @param id id del profesor a reactivar
     * @return ResponseEntity con un mensaje de exito en caso
     * de que se reactive el profesor, o un error si no se
     * encuentra o si ya esta activado
     */
    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restoreProfessor(@PathVariable Long id){
        try{
            professorService.restoreProfessor(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Profesor reactivado con exito")));
        }  catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Buscar profesores por apellido y especialidad
     * @param lastname apellido de los profesorres a buscar
     * @param specialty especialidad de los profesores a buscar
     * @return ResponseEntity con los profesores que coincidan
     * con los parametros de búsqueda, o un error en caso de
     * que no se encuentre ninguno
     */
    @GetMapping("/find")
    public ResponseEntity<ReturnResponse> findProfessorByLastNameAndSpecialty(@RequestParam String lastname, String specialty){
        try{
            List<ProfessorResponseDTO> professorResponseDTO = professorService.findByLastNameAndSpecialty(lastname, specialty);
            return ResponseEntity.ok(new ReturnResponse(professorResponseDTO));
        }   catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
}
