package com.GameAcademy.srcrankingGamePlayerManagement.dao;

import com.GameAcademy.srcrankingGamePlayerManagement.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRankingRepositoryDAO extends JpaRepository<Ranking, Long> {

}
