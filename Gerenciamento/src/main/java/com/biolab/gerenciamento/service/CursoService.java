package com.biolab.gerenciamento.service;

import com.biolab.gerenciamento.DTOs.CursoDTO;
import com.biolab.gerenciamento.entities.Curso;
import com.biolab.gerenciamento.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Classe com as regras de negócio
@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
    // Cadastra um novo curso no banco
    public String criar(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);
        return "Curso criado com sucesso!!";
    }

    // Atualiza os dados do curso
    public CursoDTO atualizar(Long id, CursoDTO dto) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        cursoRepository.save(curso);

        CursoDTO cdto = new CursoDTO();
        cdto.setId(curso.getId());
        cdto.setNome(curso.getNome());
        cdto.setCargaHoraria(curso.getCargaHoraria());
        return cdto;
    }
    // Exclui o curso pelo ID
    public String deletar(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(curso.getId());
        return "excluido!";
    }
    // Retorna a lista de curso
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }
// Busca um curso pelo ID
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow();
    }
}