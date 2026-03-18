package com.exemplo.tarefasapi.controller;

import com.exemplo.tarefasapi.model.Tarefa;
import com.exemplo.tarefasapi.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Controller REST responsável por expor os endpoints de Tarefa.
 */
@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*") // permite chamadas de qualquer origem (útil para testes com front-end)
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    /**
     * GET /tarefas
     * Lista todas as tarefas cadastradas.
     */
    @GetMapping
    public ResponseEntity<List<Tarefa>> listar() {
        List<Tarefa> tarefas = tarefaService.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    /**
     * POST /tarefas
     * Cria uma nova tarefa.
     */
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa criada = tarefaService.criar(tarefa);
        return ResponseEntity
                .created(URI.create("/tarefas/" + criada.getId()))
                .body(criada);
    }

    /**
     * PUT /tarefas/{id}
     * Atualiza uma tarefa existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        try {
            Tarefa atualizada = tarefaService.atualizar(id, tarefa);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /tarefas/{id}
     * Remove uma tarefa pelo id.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        try {
            tarefaService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

