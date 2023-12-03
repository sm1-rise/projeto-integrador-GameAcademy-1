package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import com.GameAcademy.srcrankingGamePlayerManagement.service.ranking.RankingServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class RankingController {

    @Autowired
    private RankingServiceImpl rankingService;

    @GetMapping("/ranking")
    public ResponseEntity<List<Ranking>> getAllranking(){
        var lista = rankingService.listarRanking();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ranking/jogador/{id}")
    public ResponseEntity<List<Ranking>> getJogadorRankingById(@PathVariable("id") Long id) throws JsonProcessingException {
        var lista = rankingService.listarTodosRankingJogador(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ranking/jogo/{id}")
    public ResponseEntity<List<Ranking>> getJogoSRankingById(@PathVariable("id") Long id) throws JsonProcessingException {
        var lista = rankingService.listarTodosJogosRanking(id);
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/ranking")
    public ResponseEntity<Ranking>criar(@Valid @RequestBody Ranking ranking)  {
        var rankingCriado = rankingService.criarRanking(ranking);
        return ResponseEntity.status(201).body(rankingCriado);
    }

    @DeleteMapping("\ranking{id}")
    public ResponseEntity<Ranking> delete(@PathVariable("id") Long id){
        rankingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
