package com.biolab.gerenciamento.service;

import com.biolab.gerenciamento.entities.Aluno;
import com.biolab.gerenciamento.entities.Curso;
import com.biolab.gerenciamento.entities.Matricula;
import com.biolab.gerenciamento.repository.AlunoRepository;
import com.biolab.gerenciamento.repository.CursoRepository;
import com.biolab.gerenciamento.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Classe com as regras de negócio
@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }
    // Associa um aluno a um curso
    public String matricular(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        matriculaRepository.save(matricula);
        return "Aluno matriculado no curso com sucesso!!";
    }
    // Exclui a matrícula pelo ID
    public String removerMatricula(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow();
        matriculaRepository.deleteById(matricula.getId());
        return "excluido";
    }
    // Retorna as matrículas de um aluno
    public List<Matricula> buscarMatriculasDoAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return aluno.getMatriculas();
    }
    // Retorna as matrículas de um curso
    public List<Matricula> buscarMatriculasDoCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        return curso.getMatriculas();
    }
}