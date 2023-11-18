package com.GameAcademy.srcrankingGamePlayerManagement.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@Data
@Entity
@Table(name = "jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 130)
    private String email;

    @Column(name = "nickname", nullable = false, length = 70)
    private String nickname;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    private Set<Ranking> ranking;

}