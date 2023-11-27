package com.GameAcademy.srcrankingGamePlayerManagement.service.ranking;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;

import java.util.List;

public interface IRankingService {
    public List<Ranking> getAllRanking();
    public Ranking create(Ranking ranking);
}
