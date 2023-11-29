package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IRankingRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Ranking> rankingList  = new ArrayList<>();
        var listaRanking = rankingRepository.findAll();
        listaRanking.forEach((rankingJogo) -> {
            if(rankingJogo.getJogo().getId().equals(id)){
                rankingList.add(rankingJogo);
            }
           }
        );
        return rankingList;
    }

    public List<Ranking> getAllRankingPlayerId(Long id){

        List<Ranking> rankingList  = new ArrayList<>();
        var listaRanking = rankingRepository.findAll();

        listaRanking.forEach((rankingJogador) -> {
                    if(rankingJogador.getJogador().getId().equals(id)){
                        rankingList.add(rankingJogador);
                    }
                }
        );
        return rankingList;
    }

    public void delete(Long id){
        rankingRepository.deleteById(id);
    }


}
