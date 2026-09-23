package com.biolab.gerenciamento.repository;

import com.biolab.gerenciamento.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}