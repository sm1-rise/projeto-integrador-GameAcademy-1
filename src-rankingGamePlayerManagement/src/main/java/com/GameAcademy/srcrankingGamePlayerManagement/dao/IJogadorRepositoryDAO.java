package com.GameAcademy.srcrankingGamePlayerManagement.dao;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJogadorRepositoryDAO extends JpaRepository<Jogador,Long> {
}
