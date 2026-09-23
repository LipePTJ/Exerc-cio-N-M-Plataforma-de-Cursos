package com.biolab.gerenciamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
// Entidade que representa a tabela de cursos
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    // Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    private int cargaHoraria;
    // Relacionamento de um curso para várias matrículas
    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas = new ArrayList<>();
}