package com.GameAcademy.srcrankingGamePlayerManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "pontos", nullable = false)
    private Integer pontos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jogador_id")
    private  Jogador jogador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
