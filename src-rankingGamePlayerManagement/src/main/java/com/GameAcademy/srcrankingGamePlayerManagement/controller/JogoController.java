package com.GameAcademy.srcrankingGamePlayerManagement.controller;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import com.GameAcademy.srcrankingGamePlayerManagement.service.JogoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.table.TableRowSorter;
import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.NoSuchElementException;
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
    public ResponseEntity<Jogo>update(@PathVariable("id") Long id, @RequestBody Jogo jogoAtualizado) throws JsonProcessingException {
        var jogo = jogoServiceImpl.atualizar(jogoAtualizado);
        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("/jogos/{id}")
    public  ResponseEntity delete(@PathVariable("id") Long id) throws JsonProcessingException {
        jogoServiceImpl.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
