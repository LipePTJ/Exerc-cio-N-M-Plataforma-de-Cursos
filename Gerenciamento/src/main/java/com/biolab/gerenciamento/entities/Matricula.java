package com.biolab.gerenciamento.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entidade que representa a tabela de matrículas
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {

    // Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Várias matrículas pertencem a um aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties("matriculas")
    private Aluno aluno;
    // Várias matrículas pertencem a um curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnoreProperties("matriculas")
    private Curso curso;
}