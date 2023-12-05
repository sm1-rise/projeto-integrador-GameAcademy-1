package com.GameAcademy.srcrankingGamePlayerManagement.service.jogo;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.CustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


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
        if(jogo.getId()  == null ){
            throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"O id está nulo",400);
        }

        var jogoAtualizado = jogoRepository.findById(jogo.getId());

        if(jogoAtualizado.isPresent()){
            return jogoRepository.save(jogo);
        }
        throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"Todos os campos devem ser preenchidos corretamente",400);
    }

    @Override
    public List<Jogo> buscarTodos() {
            return jogoRepository.findAll();
    }

    @Override
    public Jogo buscarPeloId(Long id) throws JsonProcessingException {
        return jogoRepository.findById(id).orElseThrow();
    }
}
