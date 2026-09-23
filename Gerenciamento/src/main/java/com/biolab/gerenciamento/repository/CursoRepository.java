package com.biolab.gerenciamento.repository;

import com.biolab.gerenciamento.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}