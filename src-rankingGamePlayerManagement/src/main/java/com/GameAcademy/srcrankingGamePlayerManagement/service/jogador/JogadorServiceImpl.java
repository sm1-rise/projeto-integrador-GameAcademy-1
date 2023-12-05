package com.GameAcademy.srcrankingGamePlayerManagement.service.jogador;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogadorRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.CustomException;
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

        if(jogador.getId()  == null ){
            throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"O id está nulo",400);
        }

        var jogadorAtualizado = jogadorRepository.findById(jogador.getId());

        if(jogadorAtualizado.isPresent()){
           return jogadorRepository.save(jogador);
       }
           throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"Todos os campos devem ser preenchidos corretamente",400);
    }

    @Override
    public List<Jogador> buscarTodos() throws JsonProcessingException {
        return  jogadorRepository.findAll();
    }

    @Override
    public Jogador buscarPeloId(Long id) throws JsonProcessingException {
        return jogadorRepository.findById(id).orElseThrow();
    }

    private void validacaoNulo(Object valor, String menssagemErro){
        if(valor == null){
            throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(), menssagemErro, 400);
        }
    }
}
