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

import java.util.ArrayList;
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
    public ProfessorResponseDTO createProfesor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = professorMapper.requestToProfesor(professorRequestDTO);
        List<Course> courses = new ArrayList<>();
        if(professorRequestDTO.getCoursesId() != null){
            courses = courseService.getAllCoursesByIds(professorRequestDTO.getCoursesId());
        }
        objProfessor.setCourses(courses);
        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public ProfessorResponseDTO asignProfesorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound {
        Professor objProfessor = getProfesorById(professorCourseRequestDTO.getProfesorId());
        Course objCourse = courseService.getCourseById(professorCourseRequestDTO.getCourseId());
        List<Course> courses = objProfessor.getCourses();
        courses.add(objCourse);
        objProfessor.setCourses(courses);
        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }

    @Override
    public Professor getProfesorById(Long profesorId) throws ExceptionNotFound {
        return professorRepository.findById(profesorId).orElseThrow(() -> new ExceptionNotFound("profesor", "ID", profesorId.toString()));
    }
    @Override
    public ProfessorResponseDTO findProfessorByID(Long id) throws ExceptionNotFound{
        Professor professor = getProfesorById(id);
        return professorMapper.profesorToResponse(professor);
    }
    @Override
    public List<ProfessorResponseDTO> findAllProfessors(){
        List<Professor> professors = professorRepository.findAll();
        return professorMapper.professorListToResponseList(professors);
    }
    @Override
    public ProfessorResponseDTO updateProfessor(Long id, ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound{
        Professor objProfessor = getProfesorById(id);

        if(professorRequestDTO.getCoursesId() != null){
            List<Course> courses = courseService.getAllCoursesByIds(professorRequestDTO.getCoursesId());
            objProfessor.setCourses(courses);
        }
        objProfessor.setDni(professorRequestDTO.getDni());
        objProfessor.setName(professorRequestDTO.getName());
        objProfessor.setLastName(professorRequestDTO.getLastName());
        objProfessor.setSpecialty(professorRequestDTO.getSpecialty());

        professorRepository.save(objProfessor);
        return professorMapper.profesorToResponse(objProfessor);
    }
    @Override
    public ProfessorResponseDTO deleteProfessor(Long id) throws ExceptionNotFound{
        Professor objProfessor = getProfesorById(id);
        if(objProfessor.getActive()){
            objProfessor.setActive(false);
        } else {
            throw new ExceptionDeletedData("Ya esta eliminado el professor con el ID: " + id, id, "Professor");
        }
        return professorMapper.profesorToResponse(objProfessor);
    }
    @Override
    public ProfessorResponseDTO findByLastNameAndSpecialty(String lastname, String specialty) throws ExceptionNotFound {
        Professor objProfessor = professorRepository.findProfessorByLastNameAndSpecialty(lastname, specialty)
                .orElseThrow(() ->
                        new ExceptionNotFound("Professor", "Apellido-Especialidad", lastname + "-" + specialty));
        return professorMapper.profesorToResponse(objProfessor);
    }
}
