package com.practice.practice.repository;

import com.practice.practice.model.Course;
import com.practice.practice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfaz de repositorio para la entidad Grade.
 * @see Grade
 * Proporciona métodos para acceder y manipular datos relacionados con calificaciones en la base de datos.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    /**
     * Metodo derivado que sirve para búscar todas las calificaciones
     * cuyo studentId coincida con el enviado por parametro
     * @param studentId id del estudiante del cual buscar las calificaciones
     * @return Lista de calificaciones cuyo studentId es el indicado
     */
    List<Grade> findAllByStudentId(Long studentId);
    /**
     * Metodo derivado que sirve para búscar todas las calificaciones
     * cuyo courseId coincida con el enviado por parametro
     * @param courseId id del curso del cual buscar las calificaciones
     * @return Lista de calificaciones cuyo courseId es el indicado
     */
    List<Grade> findAllByCourseId(Long courseId);
}
