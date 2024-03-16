package com.practice.practice.repository;

import com.practice.practice.model.Course;
import com.practice.practice.model.Professor;
import com.practice.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Interfaz de repositorio para la entidad Student.
 * @see Student
 * Proporciona métodos para acceder y manipular datos relacionados con estudiantes en la base de datos.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
