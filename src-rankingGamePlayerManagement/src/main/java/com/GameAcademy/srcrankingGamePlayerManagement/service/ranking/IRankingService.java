package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;

import java.util.List;

public interface IRankingService {

    public Ranking criarRanking(Ranking ranking);

    public List<Ranking> listarTodosRankingJogador(Long id);

    public List<Ranking> listarTodosJogosRanking(Long id);

    public List<Ranking> listarRanking();
}
