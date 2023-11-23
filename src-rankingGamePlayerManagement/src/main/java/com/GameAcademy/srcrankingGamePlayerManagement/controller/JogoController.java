package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.service.JogoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Optional<Jogo>> getById(@PathVariable("id") Long id) throws JsonProcessingException {
        var jogo = jogoServiceImpl.buscarPeloId(id);
        return ResponseEntity.ok(jogo);
    }

    @PostMapping("/jogos")
    public ResponseEntity<Jogo>create(@RequestBody Jogo jogoCriado){
        var jogo = jogoServiceImpl.criarJogo(jogoCriado);
        if(jogo != null)
            return ResponseEntity.status(201).body(jogo);
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/jogos/{id}")
    public ResponseEntity<Jogo>update(@PathVariable("id") Long id, @RequestBody Jogo jogoAtualizado) throws JsonProcessingException {
        var jogo = jogoServiceImpl.atualizar(jogoAtualizado);
        if(jogo.getId() != null ){
            return ResponseEntity.ok(jogo);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/jogos/{id}")
    public  ResponseEntity delete(@PathVariable("id") Long id) throws JsonProcessingException {
        jogoServiceImpl. excluir(id);
        return ResponseEntity.noContent().build();
    }
}
