package com.practice.practice.service;

import com.practice.practice.dto.request.ProfessorCourseRequestDTO;
import com.practice.practice.dto.request.ProfessorRequestDTO;
import com.practice.practice.dto.response.ProfessorResponseDTO;
import com.practice.practice.exception.ExceptionNotFound;
import com.practice.practice.model.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorResponseDTO createProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;
    ProfessorResponseDTO assignProfessorToCourse(ProfessorCourseRequestDTO professorCourseRequestDTO) throws ExceptionNotFound;
    Professor getProfessorById(Long id) throws ExceptionNotFound;
    ProfessorResponseDTO findProfessorByID(Long id) throws ExceptionNotFound;
    List<ProfessorResponseDTO> findAllProfessors();
    ProfessorResponseDTO updateProfessor(ProfessorRequestDTO professorRequestDTO) throws ExceptionNotFound;
    ProfessorResponseDTO deactivateProfessor(Long id) throws ExceptionNotFound;
    List<ProfessorResponseDTO> findByLastNameAndSpecialty(String lastname, String specialty) throws ExceptionNotFound;
    ProfessorResponseDTO restoreProfessor(Long id) throws ExceptionNotFound;

}
