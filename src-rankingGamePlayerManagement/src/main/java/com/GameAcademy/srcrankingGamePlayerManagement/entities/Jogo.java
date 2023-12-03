package com.GameAcademy.srcrankingGamePlayerManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jogo")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome", unique = true, nullable = false, length = 100)
    private String nome;

    @NotNull
    @Column(name = "autor",  unique = true, nullable = false, length = 100)
    private String autor;

    @Column(name = "website", unique = true, nullable = true, length = 255)
    private String website;

    @Column(name = "imagem", nullable = false,  length = 2083)
    private String imagem;

    @Column(name = "descricao", nullable = false, length = 300)
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.MERGE)
    private Set<Ranking> ranking;
}

