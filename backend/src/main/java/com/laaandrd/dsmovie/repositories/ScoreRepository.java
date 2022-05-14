package com.laaandrd.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laaandrd.dsmovie.entities.Score;
import com.laaandrd.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
