package com.practice.practice.controller;

import com.practice.practice.dto.request.GradeRequestDTO;
import com.practice.practice.dto.response.GradeResponseDTO;
import com.practice.practice.dto.response.ReturnResponse;
import com.practice.practice.dto.response.StringResponse;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.exception.ExceptionReturn;
import com.practice.practice.exception.ExceptionUnavailableConnection;
import com.practice.practice.model.Grade;
import com.practice.practice.service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador REST para manejar las peticiones relacionadas con las calificaciones
 * Maneja las peticiones hechas al endpoint /grade
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    /**
     * Servicio para las calificaciones
     */
    private final GradeService gradeService;

    /**
     * Constructor para el controlador
     * Inicializa el servicio
     * @param gradeService Servicio de calificaciones
     */
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    /**
     * Creación de calificación
     * @param gradeRequestDTO información necesaria para la creación
     * @return ResponseEntity con la calificación creada en
     * caso de exito, o con un error en caso de que no se encuentre
     * el curso o el estudiante al que se la quiere asignar, que
     * el estudiante no este inscripto en el curso o que alguno de
     * los dos se encuentre inactivo
     */
    @PostMapping
    public ResponseEntity<ReturnResponse> registerGrade (@Valid @RequestBody GradeRequestDTO gradeRequestDTO) {
        try{
            GradeResponseDTO gradeResponseDTO = gradeService.registerGrade(gradeRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(gradeResponseDTO));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        }  catch (ExceptionDeletedData | ExceptionUnavailableConnection ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Busca una calificación por ID
     * @param id id de la calificación a buscar
     * @return Response entity con la calificación encontrada,
     * o con un error en caso de que no se encuentre
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReturnResponse> getGradeById(@Valid @PathVariable Long id){
        try{
            GradeResponseDTO grade = gradeService.findGradeById(id);
            return ResponseEntity.ok(new ReturnResponse(grade));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.ok(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Busca todas las calificaciones de un estudiante
     * @param id del estudiante del cual se buscan las calificaciones
     * @return ResponseEntity con todas las calificaciones del estudiante
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<ReturnResponse> getGradeByStudentId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByStudentId(id);
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }
    /**
     * Busca todas las calificaciones de un curso
     * @param id del curso del cual se buscan las calificaciones
     * @return ResponseEntity con todas las calificaciones del curso
     */
    @GetMapping("/course/{id}")
    public ResponseEntity<ReturnResponse> getGradeByCourseId(@Valid @PathVariable Long id){
        List<GradeResponseDTO> gradeList = gradeService.getGradeByCourseId(id);
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }

    /**
     * Busca todas las notas registradas
     * @return ResponseEntity con todas las notas registradas
     */
    @GetMapping
    public ResponseEntity<ReturnResponse> getAllGrades(){
        List<GradeResponseDTO> gradeList = gradeService.getAllGrades();
        return ResponseEntity.ok(new ReturnResponse(gradeList));
    }

    /**
     * Actualiza los datos de una calificación
     * @param gradeRequestDTO información de la calificación a actualizar
     * @return ResponseEntity con la calificación actualizada,
     * o un error en caso de que no se encuentre la calificación, el
     * estudiante o el curso, de que alguno de los tres se encuntre
     * desactivo o que el estudiante no este inscripto en el curso
     * indicado
     */
    @PutMapping
    public ResponseEntity<ReturnResponse> updateGrade(@Valid @RequestBody GradeRequestDTO gradeRequestDTO){
        try{
            GradeResponseDTO objGrade = gradeService.updateGrade(gradeRequestDTO);
            return ResponseEntity.ok(new ReturnResponse(objGrade));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData | ExceptionUnavailableConnection ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }

    }

    /**
     * Desactiva una calificación
     * @param id id de la calificación a desactivar
     * @return ResponseEntity con un mensaje de exito en caso de
     * desactivar la calificación, o un error en caso de que no
     * se encuentre la calificación o ya este desactivada
     */
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<ReturnResponse> deactivateGrade(@PathVariable Long id){
        try{
            gradeService.deactivateGrade(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Nota desactivada con éxito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }

    /**
     * Reactiva una calificación
     * @param id id de la calificación a reactivar
     * @return ResponseEntity con un mensaje de exito en caso de
     * reactivar la calificación, o un error en caso de que no
     * se encuentre la calificación o ya este activa
     */
    @PutMapping("/restore/{id}")
    public ResponseEntity<ReturnResponse> restoreGrade(@PathVariable Long id){
        try{
            gradeService.restoreGrade(id);
            return ResponseEntity.ok(new ReturnResponse(new StringResponse("Nota reactivada con éxito")));
        } catch (ExceptionNotFound ex){
            return ResponseEntity.status(404).body(new ReturnResponse(new ExceptionReturn(ex)));
        } catch (ExceptionDeletedData ex){
            return ResponseEntity.status(500).body(new ReturnResponse(new ExceptionReturn(ex)));
        }
    }
}
