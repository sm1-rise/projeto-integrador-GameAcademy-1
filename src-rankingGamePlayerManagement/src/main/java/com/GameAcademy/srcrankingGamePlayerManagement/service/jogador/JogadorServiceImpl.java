package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogadorRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorServiceImpl implements IJogadorService {

    @Autowired
    private IJogadorRepositoryDAO jogadorRepository;

    @Override
    public Jogador criarJogador(Jogador novoJogador) throws JsonProcessingException {
        return jogadorRepository.save(novoJogador);
    }

    @Override
    public Jogador atualizar(Long id, Jogador jogo) throws JsonProcessingException {
        return jogadorRepository.save(jogo);
    }

    @Override
    public List<Jogador> buscarTodos() throws JsonProcessingException {
        return  jogadorRepository.findAll();
    }

    @Override
    public Jogador buscarPeloId(Long id) throws JsonProcessingException {
        return jogadorRepository.findById(id).orElseThrow();
    }

    @Override
    public void excluir(Long id) throws JsonProcessingException {
        jogadorRepository.deleteById(id);
    }
}