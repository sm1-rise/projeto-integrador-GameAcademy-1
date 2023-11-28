package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IRankingRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements IRankingService{

    @Autowired
    public IRankingRepositoryDAO rankingRepository;

    @Override
    public Ranking create(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    public List<Ranking> encontrarTodos(){
        var lista = rankingRepository.findAll();
        return lista;
    }

    public List<Ranking> getAllRankingJogoId(Long id){
        return rankingRepository.findJogoRankingById(id);
    }

    public List<Ranking> getAllRankingPlayerId(Long id){
        return rankingRepository.findJogadorRankingById(id);
    }

    public void delete(Long id){
        rankingRepository.deleteById(id);
    }


}
