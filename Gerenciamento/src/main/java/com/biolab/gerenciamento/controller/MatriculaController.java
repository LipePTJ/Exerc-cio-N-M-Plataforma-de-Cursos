package com.biolab.gerenciamento.controller;
import com.biolab.gerenciamento.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

private final MatriculaService service;
public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    // matricular um aluno em um curso
     @PostMapping("/{alunoId}/{cursoId}")
     public ResponseEntity<?> matricular(@PathVariable Long alunoId, @PathVariable Long cursoId) {
     return ResponseEntity.ok(service.matricular(alunoId, cursoId));
    }
    // remover uma matrícula por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerMatricula(@PathVariable Long id) {
    return ResponseEntity.ok(service.removerMatricula(id));
    }
    //buscar todas as matrículas de um aluno
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<?> buscarMatriculasDoAluno(@PathVariable Long alunoId) {
        return ResponseEntity.ok(service.buscarMatriculasDoAluno(alunoId));
    }
    //  buscar todas as matrículas de um curso
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<?> buscarMatriculasDoCurso(@PathVariable Long cursoId) {
    return ResponseEntity.ok(service.buscarMatriculasDoCurso(cursoId));
    }
}