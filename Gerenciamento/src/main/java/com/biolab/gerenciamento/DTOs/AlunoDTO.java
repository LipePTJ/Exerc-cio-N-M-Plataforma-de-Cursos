package com.biolab.gerenciamento.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;

    //criação de cadastro (sem ID)
    public AlunoDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}