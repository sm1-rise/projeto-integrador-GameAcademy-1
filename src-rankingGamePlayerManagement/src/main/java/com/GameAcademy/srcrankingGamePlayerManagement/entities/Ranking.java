package com.GameAcademy.srcrankingGamePlayerManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "ranking")
public class Ranking  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pontos", nullable = false)
    private Integer pontos;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createAt", nullable = false, updatable = false)
    private Date createAt;
    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "jogador_id")
    private  Jogador jogador;

    @ManyToOne (cascade = CascadeType.MERGE)
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;


    @PrePersist
    protected void onCreate() {
        createAt = new Date();
    }
}
