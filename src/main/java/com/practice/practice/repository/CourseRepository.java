package com.practice.practice.repository;

import com.practice.practice.model.Course;
import com.practice.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfaz de repositorio para la entidad Course.
 * @see Course
 * Proporciona métodos para acceder y manipular datos relacionados con cursos en la base de datos.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
