package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;

import java.util.List;
import java.util.Optional;

public interface IJogoService {
    public Jogo criarJogo(Jogo novoJogo);
    public Jogo atualizar(Jogo jogo);

    public List<Jogo>buscarTodos();
    public Optional<Jogo> buscarPeloId(Long id);
    public void excluir(Long id);
}
