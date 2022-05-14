package com.laaandrd.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laaandrd.dsmovie.dto.MovieDTO;
import com.laaandrd.dsmovie.dto.ScoreDTO;
import com.laaandrd.dsmovie.entities.Movie;
import com.laaandrd.dsmovie.entities.Score;
import com.laaandrd.dsmovie.entities.User;
import com.laaandrd.dsmovie.repositories.MovieRepository;
import com.laaandrd.dsmovie.repositories.ScoreRepository;
import com.laaandrd.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setUser(user);
		score.setMovie(movie);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		Double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		Double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return (new MovieDTO(movie));
		
	}
	

	
}
