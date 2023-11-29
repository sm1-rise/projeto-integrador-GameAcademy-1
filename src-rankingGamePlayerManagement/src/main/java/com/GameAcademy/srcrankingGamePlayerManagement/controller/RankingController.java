package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import com.GameAcademy.srcrankingGamePlayerManagement.service.jogo.JogoServiceImpl;
import com.GameAcademy.srcrankingGamePlayerManagement.service.ranking.RankingServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;


@RestController
public class RankingController {

    @Autowired
    private RankingServiceImpl rankingService;

    @GetMapping("/ranking/jogador/{id}")
    public ResponseEntity<List<Ranking>> getJogoRankingById(@PathVariable("id") Long id) throws JsonProcessingException {
        var lista = rankingService.getAllRankingPlayerId(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ranking/jogo/{id}")
    public ResponseEntity<List<Ranking>> getJogoJogoById(@PathVariable("id") Long id) throws JsonProcessingException {
        var lista = rankingService.getAllRankingJogoId(id);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Ranking>> getall() throws JsonProcessingException {
        try {
            var lista =  rankingService.encontrarTodos();
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/ranking")
    public ResponseEntity<Ranking>create(@Valid @RequestBody Ranking ranking)  {
        try{
            var rankingCriado = rankingService.create(ranking);
            return ResponseEntity.status(201).body(rankingCriado);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
