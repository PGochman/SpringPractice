package com.practice.practice.repository;

import com.practice.practice.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<List<Professor>> findAllByLastNameContainingAndSpecialtyContaining(String lastName, String specialty);
}
