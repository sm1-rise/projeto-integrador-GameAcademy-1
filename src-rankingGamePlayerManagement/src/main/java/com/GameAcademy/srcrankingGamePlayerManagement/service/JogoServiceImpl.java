package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.JogoCustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class JogoServiceImpl implements IJogoService {

    @Autowired
    private IJogoRepositoryDAO jogoRepository;

    @Override
    public Jogo criarJogo(Jogo novoJogo) throws JsonProcessingException{
            return jogoRepository.save(novoJogo);
    }

    @Override
    public Jogo atualizar(Long id, Jogo jogo) throws JsonProcessingException {
            return jogoRepository.save(jogo);
    }

    @Override
    public List<Jogo> buscarTodos() throws JsonProcessingException {
            return jogoRepository.findAll();
    }

    @Override
    public Jogo buscarPeloId(Long id) throws JsonProcessingException {
        return jogoRepository.findById(id).orElseThrow();
    }

    @Override
    public void excluir(Long id) throws JsonProcessingException {
        jogoRepository.deleteById(id);
    }
}