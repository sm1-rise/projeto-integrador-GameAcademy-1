package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface IJogoService {

    public Jogo criarJogo(Jogo novoJogo);
    public Jogo atualizar(Jogo jogo) throws JsonProcessingException;
    public List<Jogo>buscarTodos() throws JsonProcessingException;
    public Optional<Jogo> buscarPeloId(Long id) throws JsonProcessingException;
    public void excluir(Long id) throws JsonProcessingException;
}
