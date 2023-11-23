package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.JogoErro;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.JogoCustomException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feign.FeignException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class JogoServiceImpl implements IJogoService {

    @Autowired
    private IJogoRepositoryDAO jogoRepository;

    @Override
    public Jogo criarJogo(Jogo novoJogo) {
        return jogoRepository.save(novoJogo);
    }
    @Override
    public Jogo atualizar(Jogo jogo) throws JsonProcessingException {
        try {
            if (jogoRepository.existsById(jogo.getId()))
                return jogoRepository.save(jogo);
            else throw new JogoCustomException();
        }catch (FeignException e){
            var respostaJogo = new ObjectMapper().readValue(e.contentUTF8(), JogoErro.class);
            throw  new JogoCustomException(respostaJogo.getCodigoErro(),respostaJogo.getMensagem(),e.status());
        }
    }

    @Override
    public List<Jogo> buscarTodos() throws JsonProcessingException {
        try {
            return jogoRepository.findAll();
        }catch (FeignException e){
            var respostaJogo = new ObjectMapper().readValue(e.contentUTF8(), JogoErro.class);
            throw  new JogoCustomException(respostaJogo.getCodigoErro(),respostaJogo.getMensagem(),e.status());
        }
    }

    @Override
    public Optional<Jogo> buscarPeloId(Long id) throws JsonProcessingException {
        try {
            if(jogoRepository.existsById(id))
                return  jogoRepository.findById(id);
            else
                throw new JogoCustomException();
        } catch (FeignException e){
            var respostaJogo = new ObjectMapper().readValue(e.contentUTF8(), JogoErro.class);
            throw  new JogoCustomException(respostaJogo.getCodigoErro(),respostaJogo.getMensagem(),e.status());
        }
    }

    @Override
    public void excluir(Long id) throws JsonProcessingException {
        try {
            if(jogoRepository.existsById(id))
                jogoRepository.deleteById(id);
            else
                throw new JogoCustomException();
        } catch (FeignException e) {
            var respostaJogo = new ObjectMapper().readValue(e.contentUTF8(), JogoErro.class);
            throw  new JogoCustomException(respostaJogo.getCodigoErro(),respostaJogo.getMensagem(),e.status());
        }

    }
}



/*} catch (Exception e) {
        // Logue a exceção para análise
        e.printStackTrace();
        return ResponseEntity.status(500).build();
        }
        }

        */