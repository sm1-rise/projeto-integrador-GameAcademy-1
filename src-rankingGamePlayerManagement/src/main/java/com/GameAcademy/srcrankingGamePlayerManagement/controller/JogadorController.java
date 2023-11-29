package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import com.GameAcademy.srcrankingGamePlayerManagement.service.jogador.JogadorServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class JogadorController {
    @Autowired
    private JogadorServiceImpl jogadorServiceImpl;

    @GetMapping("/jogadores")
    public ResponseEntity<List<Jogador>> getAll() throws JsonProcessingException {
        var lista = jogadorServiceImpl.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/jogadores/{id}")
    public ResponseEntity<Jogador>getById(@PathVariable("id") Long id) throws JsonProcessingException {
        var jogadorEncontrado = jogadorServiceImpl.buscarPeloId(id);
        return ResponseEntity.ok(jogadorEncontrado);
    }

    @PostMapping("/jogadores")
    public ResponseEntity<Jogador>create(@Valid @RequestBody Jogador jogador) throws JsonProcessingException {
        var jogadorCriado = jogadorServiceImpl.criarJogador(jogador);
        return ResponseEntity.status(201).body(jogadorCriado);
    }

    @PutMapping("/jogadores/{id}")
    public ResponseEntity<Jogador>update(@PathVariable("id") Long id, @RequestBody Jogador jogador) throws JsonProcessingException {
           return ResponseEntity.ok(jogadorServiceImpl.atualizar(id,jogador));
    }
}