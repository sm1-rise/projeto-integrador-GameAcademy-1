package com.GameAcademy.srcrankingGamePlayerManagement.service.jogo;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Jogo> jogoAtualizado = jogoRepository.findById(id);
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
}
