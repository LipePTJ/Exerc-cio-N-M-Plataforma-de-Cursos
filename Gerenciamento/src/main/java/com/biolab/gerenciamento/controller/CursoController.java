package com.biolab.gerenciamento.controller;

import com.biolab.gerenciamento.DTOs.CursoDTO;
import com.biolab.gerenciamento.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }
// cadastrar um novo curso
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody CursoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }
    //  buscar curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }
// listar todos os cursos
    @GetMapping
    public ResponseEntity<?> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }
 // atualizar os dados de um curso
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        CursoDTO cursoAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(cursoAtualizado);
    }
    // deletar um curso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}