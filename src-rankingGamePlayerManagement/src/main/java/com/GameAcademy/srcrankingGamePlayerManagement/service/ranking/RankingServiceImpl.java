package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IRankingRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RankingServiceImpl implements IRankingService{

    @Autowired
    public IRankingRepositoryDAO rankingRepository;

    @Override
    public Ranking criarRanking(Ranking ranking) {
        return rankingRepository.save(ranking);
    }

    @Override
    public List<Ranking> listarTodosRankingJogador(Long id) {
        List<Ranking> rankingList = new ArrayList<>();
        var listaRanking = rankingRepository.findAll();
        listaRanking.forEach((rankingJogador) -> {
            if (rankingJogador.getJogador().getId().equals(id)) {
                rankingList.add(rankingJogador);
            }
        });
        Collections.sort(rankingList, Comparator.comparingInt(Ranking::getPontos).reversed());
        return rankingList;
    }

    @Override
    public List<Ranking> listarTodosJogosRanking(Long id) {
        List<Ranking> rankingList  = new ArrayList<>();
        var listaRanking = rankingRepository.findAll();
        listaRanking.forEach((rankingJogo) -> {
                    if(rankingJogo.getJogo().getId().equals(id)){
                        rankingList.add(rankingJogo);
                    }
                }
        );
        Collections.sort(rankingList, Comparator.comparingInt(Ranking::getPontos).reversed());
        return rankingList;
    }

    @Override
    public List<Ranking> listarRanking(){
        var ranking = rankingRepository.findAll();
        Collections.sort(ranking, Comparator.comparingInt(Ranking::getPontos).reversed());
        return ranking;
    }

    public void delete(Long id){
        rankingRepository.deleteById(id);
    }


}
