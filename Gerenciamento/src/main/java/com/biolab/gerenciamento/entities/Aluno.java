package com.biolab.gerenciamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

// Entidade que representa a tabela de alunos
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    // Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(length = 150)
    private String email;
    // Relacionamento de um aluno para várias matrículas
    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas = new ArrayList<>();
}