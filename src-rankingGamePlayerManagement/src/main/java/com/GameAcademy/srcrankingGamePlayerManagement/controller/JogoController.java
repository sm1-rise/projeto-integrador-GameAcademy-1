package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;

import com.GameAcademy.srcrankingGamePlayerManagement.service.jogo.JogoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import javax.validation.Valid;
import java.util.List;
@Controller
public class JogoController {
    @Autowired
    private JogoServiceImpl jogoServiceImpl;

    @GetMapping("/jogos")
    public ResponseEntity<List<Jogo>> getAll() throws JsonProcessingException {
        var lista = jogoServiceImpl.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/jogos/{id}")
    public ResponseEntity<Jogo>getById(@PathVariable("id") Long id) throws JsonProcessingException {
            var jogoEncontrado = jogoServiceImpl.buscarPeloId(id);
            return ResponseEntity.ok(jogoEncontrado);
    }

    @PostMapping("/jogos")
    public ResponseEntity<Jogo>create(@Valid @RequestBody Jogo jogoCriado) throws JsonProcessingException {
        var jogo = jogoServiceImpl.criarJogo(jogoCriado);
        return ResponseEntity.status(201).body(jogo);
    }

    @PutMapping("/jogos/{id}")
    public ResponseEntity<Jogo>update(@PathVariable("id") Long id, @RequestBody Jogo jogo) throws JsonProcessingException {
            return ResponseEntity.ok(jogo);
        }
    }

