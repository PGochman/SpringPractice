package com.practice.practice.repository;

import com.practice.practice.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findAllByStudentId(Long studentId);
    List<Calificacion> findAllByCourseId(Long courseId);
}
