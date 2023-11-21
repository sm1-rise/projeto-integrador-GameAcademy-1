package com.GameAcademy.srcrankingGamePlayerManagement.dao;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJogoRepositoryDAO extends JpaRepository<Jogo, Long> {
}
