package com.GameAcademy.srcrankingGamePlayerManagement.service.jogador;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogadorRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.JogoCustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorServiceImpl implements IJogadorService {

    @Autowired
    private IJogadorRepositoryDAO jogadorRepository;

    @Override
    public Jogador criarJogador(Jogador novoJogador) throws JsonProcessingException {
        return jogadorRepository.save(novoJogador);
    }

    @Override
    public Jogador atualizar(Long id, Jogador jogador) throws JsonProcessingException {
       if(jogador.getId().equals(id)){
           var jogadorDb = jogadorRepository.findById(id);
           jogadorDb.get().setEmail(jogador.getEmail());
           jogadorDb.get().setNome(jogador.getNome());
           jogadorDb.get().setNickname(jogador.getNickname());
           return jogadorRepository.save(jogadorDb.get());
       }
       else{
           throw new JogoCustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"id do jogador e URL devem ser iguais",400);
       }
    }

    @Override
    public List<Jogador> buscarTodos() throws JsonProcessingException {
        return  jogadorRepository.findAll();
    }

    @Override
    public Jogador buscarPeloId(Long id) throws JsonProcessingException {
        return jogadorRepository.findById(id).orElseThrow();
    }
}
