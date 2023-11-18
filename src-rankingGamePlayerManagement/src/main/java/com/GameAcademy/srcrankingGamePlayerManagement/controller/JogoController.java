package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.service.JogoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping("/jogo")
    public ResponseEntity<List<Jogo>>getAll(){
        return ResponseEntity.ok(jogoService.getAll());
    }

    @GetMapping("/jogo/{id}")
    public ResponseEntity<Jogo> getById(@PathVariable("id") Long id) {
        var jogo = jogoService.getById(id);
        return ResponseEntity.ok(jogo.get());
    }


    @PostMapping("/jogo")
    public ResponseEntity<Jogo>create(@RequestBody Jogo jogoCriado){
        var novoJogo = jogoService.create(jogoCriado);
        return ResponseEntity.status(201).body(novoJogo);
    }


}
