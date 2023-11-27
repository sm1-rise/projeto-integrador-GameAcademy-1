package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface IJogadorService {

    public Jogador criarJogador(Jogador novoJogador) throws JsonProcessingException;
    public Jogador atualizar(Long id, Jogador jogo) throws JsonProcessingException;
    public List<Jogador>buscarTodos() throws JsonProcessingException;
    public Jogador buscarPeloId(Long id)throws JsonProcessingException;
    public void excluir(Long id) throws JsonProcessingException;
}
