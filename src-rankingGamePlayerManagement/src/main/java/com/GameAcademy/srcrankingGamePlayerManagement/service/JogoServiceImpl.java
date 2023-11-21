package com.GameAcademy.srcrankingGamePlayerManagement.service;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoServiceImpl implements IJogoService {

    @Autowired
    private IJogoRepositoryDAO jogoRepository;

    @Override
    public Jogo criarJogo(Jogo novoJogo) {
        return jogoRepository.save(novoJogo);
    }
    @Override
    public Jogo atualizar(Jogo jogo) {
        if(jogoRepository.existsById(jogo.getId()))
            return jogoRepository.save(jogo);
        else return null;
    }

    @Override
    public List<Jogo> buscarTodos() {
        return jogoRepository.findAll();
    }

    @Override
    public Optional<Jogo> buscarPeloId(Long id) {
        if(jogoRepository.existsById(id))
            return  jogoRepository.findById(id);
        else return  null;
    }

    @Override
    public void excluir(Long id) {
        if(jogoRepository.existsById(id))
            jogoRepository.deleteById(id);
    }
}



/*} catch (Exception e) {
        // Logue a exceção para análise
        e.printStackTrace();
        return ResponseEntity.status(500).build();
        }
        }

        */