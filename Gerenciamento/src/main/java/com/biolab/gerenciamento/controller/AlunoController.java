package com.biolab.gerenciamento.controller;
import com.biolab.gerenciamento.DTOs.AlunoDTO;
import com.biolab.gerenciamento.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }

    // cadastrar um novo aluno
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody AlunoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }
    // buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
    // listar todos os alunos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    // atualizar os dados de um aluno
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody AlunoDTO dto) {
        AlunoDTO alunoAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(alunoAtualizado);
    }
    // deletar um aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}