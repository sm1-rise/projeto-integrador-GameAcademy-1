package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.repository.IJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private IJogoRepository jogoRepository;

    @Transactional
    public List<Jogo> getAll(){
        List<Jogo> lista =  jogoRepository.findAll();
        return lista;
    }

    @Transactional
    public Optional<Jogo> getById(Long id){
        return jogoRepository.findById(id);
    }

    @Transactional
    public Jogo create(Jogo jogoCriado){
        return  jogoRepository.save(jogoCriado);
    }

    @Transactional
    public Jogo update (Long id, Jogo jogoAtualizado){
        var jogo = jogoRepository.findById(id);
        if(jogo.isPresent()){
            return jogoRepository.save(jogoAtualizado);
        }
        return null;
    }

    @Transactional
    public void delete (Long id, Optional<Jogo> jogoDeletado){
        jogoDeletado = jogoRepository.findById(id);
        if(jogoDeletado.isPresent()){
            jogoRepository.deleteById(id);
        }
    }
}
