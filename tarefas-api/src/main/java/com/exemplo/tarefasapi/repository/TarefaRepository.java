package com.exemplo.tarefasapi.repository;

import com.exemplo.tarefasapi.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Camada de acesso a dados da entidade Tarefa.
 * Extende JpaRepository para fornecer operações CRUD prontas.
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

