package com.GameAcademy.srcrankingGamePlayerManagement.service.jogo;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.JogoCustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(jogo.getId().equals(id)){
            var jogoAtualizado = jogoRepository.findById(id);
                jogoAtualizado.get().setNome(jogo.getNome());
                jogoAtualizado.get().setAutor(jogo.getAutor());
                jogoAtualizado.get().setWebsite(jogo.getWebsite());
                jogoAtualizado.get().setImagem(jogo.getImagem());
                jogoAtualizado.get().setDescricao(jogo.getDescricao());
            return jogoRepository.save(jogoAtualizado.get());
        }
        throw new JogoCustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"id do jogador e URL devem ser iguais",400);
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
