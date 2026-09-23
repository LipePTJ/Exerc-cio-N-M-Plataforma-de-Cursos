package com.biolab.gerenciamento.service;

import com.biolab.gerenciamento.DTOs.AlunoDTO;
import com.biolab.gerenciamento.entities.Aluno;
import com.biolab.gerenciamento.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

private final AlunoRepository alunoRepository;

public AlunoService(AlunoRepository alunoRepository) {
    this.alunoRepository = alunoRepository;
}

    // Cadastra um novo aluno
public String criar(AlunoDTO dto) {
    Aluno aluno = new Aluno();
    aluno.setNome(dto.getNome());
    aluno.setEmail(dto.getEmail());
    alunoRepository.save(aluno);
    return "Aluno criado com sucesso";
}
    // Atualiza os dados do aluno
public AlunoDTO atualizar(Long id, AlunoDTO dto) {
    Aluno aluno = alunoRepository.findById(id).orElseThrow();
    aluno.setNome(dto.getNome());
    aluno.setEmail(dto.getEmail());
    alunoRepository.save(aluno);

    AlunoDTO adto = new AlunoDTO();
    adto.setId(aluno.getId());
    adto.setNome(aluno.getNome());
    adto.setEmail(aluno.getEmail());
    return adto;
}
    // Exclui o aluno
public String deletar(Long id) {
    Aluno aluno = alunoRepository.findById(id).orElseThrow();
    alunoRepository.deleteById(aluno.getId());
    return "excluido!";
}
    // Retorna a lista de todos os alunos
    public List<Aluno> buscarTodos() {
    return alunoRepository.findAll();
    }
    // Busca um aluno pelo ID
    public Aluno buscarPorId(Long id) {
    return alunoRepository.findById(id).orElseThrow();
    }
}