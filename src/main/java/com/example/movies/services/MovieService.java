package com.example.movies.services;

import com.example.movies.dtos.MovieDTO;
import com.example.movies.models.MovieModel;
import com.example.movies.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {
    @Autowired
    MovieRepository repository;

    public List<MovieModel> getAllMovies() {
        return repository.findAll();
    }

    public MovieModel getMovie(UUID id) {
        var movieO = repository.findById(id);
        if (movieO.isEmpty()) {
            throw new EntityNotFoundException("Movie not found.");
        }
        return movieO.get();
    }

    public MovieModel saveMovie(MovieDTO data) {
        var movie = new MovieModel();
        BeanUtils.copyProperties(data, movie);
        return repository.save(movie);
    }

    public MovieModel updateMovie(UUID id, MovieDTO data) {
        Optional<MovieModel> movieO = repository.findById(id);
        if (movieO.isEmpty()) {
            throw new EntityNotFoundException("Movie not found.");
        }
        var movie = movieO.get();
        BeanUtils.copyProperties(data, movie);
        return repository.save(movie);
    }

    public void deleteMovie(UUID id) {
        Optional<MovieModel> movieO = repository.findById(id);
        if (movieO.isEmpty()) {
            throw new EntityNotFoundException("Movie not found.");
        }
        repository.delete(movieO.get());
    }
}
