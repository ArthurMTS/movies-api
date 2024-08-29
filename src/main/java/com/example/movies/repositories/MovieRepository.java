package com.example.movies.repositories;

import com.example.movies.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieModel, UUID> {}
