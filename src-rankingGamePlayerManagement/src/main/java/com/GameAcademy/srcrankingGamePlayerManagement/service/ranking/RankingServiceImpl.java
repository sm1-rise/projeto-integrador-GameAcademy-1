package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogadorRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IJogoRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.dao.IRankingRepositoryDAO;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import com.GameAcademy.srcrankingGamePlayerManagement.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RankingServiceImpl implements IRankingService{

    @Autowired
    public IRankingRepositoryDAO rankingRepository;
    @Autowired
    public IJogadorRepositoryDAO jogadorRepository;
    @Autowired
    public IJogoRepositoryDAO jogoRepositoryDAO;

    @Override
    public Ranking criarRanking(Ranking ranking) {

        var jogo = jogoRepositoryDAO.findById(ranking.getJogo().getId());
        var jogador =  jogadorRepository.findById(ranking.getJogador().getId());

        if(!jogador.isPresent()){
            throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"Jogador não encontrado!",400);
        }

        if(!jogo.isPresent()){
            throw new CustomException(HttpStatus.BAD_REQUEST.getReasonPhrase(),"Jogo não encontrado!",400);
        }

        final Ranking rankingCriado = Ranking.builder()
                .pontos(ranking.getPontos())
                .jogador(jogador.get())
                .jogo(jogo.get())
                .createAt(ranking.getCreateAt()).build();
        return rankingRepository.save(rankingCriado);
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
