package com.GameAcademy.srcrankingGamePlayerManagement.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
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

    @Column(name = "website", unique = true, nullable = true)
    private String website;

    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL)
    private Set<Ranking> ranking;
}
