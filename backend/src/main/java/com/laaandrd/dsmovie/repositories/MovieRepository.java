package com.laaandrd.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laaandrd.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
