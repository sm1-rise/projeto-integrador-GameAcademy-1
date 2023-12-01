package com.GameAcademy.srcrankingGamePlayerManagement.service.jogo;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IJogoService {

    public Jogo criarJogo(Jogo novoJogo) throws JsonProcessingException;
    public Jogo atualizar(Long id, Jogo jogo) throws JsonProcessingException;
    public List<Jogo>buscarTodos() throws JsonProcessingException;
    public Jogo buscarPeloId(Long id)throws JsonProcessingException;
}
