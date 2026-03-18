package com.exemplo.tarefasapi.service;

import com.exemplo.tarefasapi.model.Tarefa;
import com.exemplo.tarefasapi.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de regras de negócio para Tarefa.
 */
@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    /**
     * Retorna todas as tarefas cadastradas.
     */
    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    /**
     * Cria uma nova tarefa.
     */
    public Tarefa criar(Tarefa tarefa) {
        // Garante valor padrão para concluido, se vier nulo
        if (tarefa.getConcluido() == null) {
            tarefa.setConcluido(false);
        }
        return tarefaRepository.save(tarefa);
    }

    /**
     * Atualiza uma tarefa existente pelo id.
     */
    public Tarefa atualizar(Long id, Tarefa dadosAtualizados) {
        Tarefa existente = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));

        existente.setTitulo(dadosAtualizados.getTitulo());
        existente.setConcluido(dadosAtualizados.getConcluido());

        return tarefaRepository.save(existente);
    }

    /**
     * Remove uma tarefa pelo id.
     */
    public void remover(Long id) {
        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }
        tarefaRepository.deleteById(id);
    }
}

