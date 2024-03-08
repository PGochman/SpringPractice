package com.practice.practice.service.implementation;

import com.practice.practice.dto.mapper.ProfessorMapper;
import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionDeletedData;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Course;
import com.practice.practice.model.Professor;
import com.practice.practice.repository.ProfessorRepository;
import com.practice.practice.service.CourseService;
import com.practice.practice.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImplementation implements ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;
    private final CourseService courseService;

    public ProfessorServiceImplementation(ProfessorRepository professorRepository, ProfessorMapper professorMapper, CourseService courseService) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
        this.courseService = courseService;
    }

    @Override
    public ProfessorResponseDTO createProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = professorMapper.requestToProfesor(professorRequestDTO);

        objProfessor.setActive(true);
        if(professorRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(professorRequestDTO.getCoursesId());
            objProfessor.setCourses(courses);
        }

        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public ProfessorResponseDTO assignProfessorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = getProfessorById(professorCourseRequestDTO.getProfesorId());
        Course objCourse = courseService.getCourseById(professorCourseRequestDTO.getCourseId());

        objProfessor.getCourses().add(objCourse);

        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public Professor getProfessorById(Long profesorId) throws ExceptionNotFound {
        return professorRepository.findById(profesorId).orElseThrow(() -> new ExceptionNotFound("profesor", "ID", profesorId.toString()));
    }
    @Override
    public ProfessorResponseDTO findProfessorByID(Long id) throws ExceptionNotFound{
        Professor professor = getProfessorById(id);
        return professorMapper.profesorToResponse(professor);
    }
    @Override
    public List<ProfessorResponseDTO> findAllProfessors(){
        List<Professor> professors = professorRepository.findAll();
        return professorMapper.professorListToResponseList(professors);
    }
    @Override
    public ProfessorResponseDTO updateProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound{
        if(!getProfessorById(professorRequestDTO.getId()).getActive()){
            throw new ExceptionDeletedData("El profesor con ID: " + professorRequestDTO.getId() + " ya se encuentra desactivado",
                    professorRequestDTO.getId(),
                    "Professor");
        }

        Professor objProfessor = professorMapper.requestToProfesor(professorRequestDTO);

        if(professorRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(professorRequestDTO.getCoursesId());
            objProfessor.setCourses(courses);
        }
        objProfessor.setActive(true);

        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }
    @Override
    public ProfessorResponseDTO deactivateProfessor(Long id) throws ExceptionNotFound{
        Professor objProfessor = getProfessorById(id);
        if(!objProfessor.getActive()){
            throw new ExceptionDeletedData("Ya esta eliminado el professor con el ID: " + id, id, "Professor");
        }
        objProfessor.setActive(false);
        return professorMapper.profesorToResponse(objProfessor);
    }
    @Override
    public List<ProfessorResponseDTO> findByLastNameAndSpecialty(String lastname, String specialty) throws ExceptionNotFound {
        List<Professor> objProfessors = professorRepository.findAllByLastNameContainingAndSpecialtyContaining(lastname, specialty)
                .orElseThrow(() ->
                        new ExceptionNotFound("Professor", "Apellido-Especialidad", lastname + "-" + specialty));
        if(objProfessors.isEmpty()){
            throw new ExceptionNotFound("Professor", "Apellido-Especialidad", lastname + "-" + specialty);
        }
        return professorMapper.professorListToResponseList(objProfessors);
    }

    @Override
    public ProfessorResponseDTO restoreProfessor(Long id) throws ExceptionNotFound{
        Professor objProfessor = getProfessorById(id);
        if(objProfessor.getActive()){
            throw new ExceptionDeletedData("El professor con el ID: " + id + " ya se encuentra activo", id, "Professor");
        }
        objProfessor.setActive(true);
        return professorMapper.profesorToResponse(objProfessor);
    }
}
