package com.biolab.gerenciamento.repository;

import com.biolab.gerenciamento.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}