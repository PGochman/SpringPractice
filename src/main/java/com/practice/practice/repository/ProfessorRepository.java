package com.practice.practice.repository;

import com.practice.practice.model.Grade;
import com.practice.practice.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Interfaz de repositorio para la entidad Professor.
 * @see Professor
 * Proporciona métodos para acceder y manipular datos relacionados con profesores en la base de datos.
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    /**
     * Metodo derivado que sirve para búscar todos los profesores cuyo apellido
     * y especialidad coincidan parcialmente con los enviados por parametro
     * @param lastName apellido parcial del profesor
     * @param specialty especialidad parcial del profesor
     * @return Lista de profesores encontrados
     */
    Optional<List<Professor>> findAllByLastNameContainingAndSpecialtyContaining(String lastName, String specialty);
}
