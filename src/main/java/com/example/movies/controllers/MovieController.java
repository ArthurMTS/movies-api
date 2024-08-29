package com.example.movies.controllers;

import com.example.movies.dtos.MovieDTO;
import com.example.movies.models.MovieModel;
import com.example.movies.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService service;

    @PostMapping
    public ResponseEntity<MovieModel> saveMovie(@RequestBody @Valid MovieDTO data) {
        var movie = service.saveMovie(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieModel>> getAllMovies() {
        var movies = service.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieModel> getMovie(@PathVariable UUID id) {
        var movie = service.getMovie(id);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieModel> updateMovie(
            @PathVariable UUID id,
            @RequestBody @Valid MovieDTO data
    ) {
        var movie = service.updateMovie(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable UUID id) {
        service.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Movie deleted.");
    }
}
