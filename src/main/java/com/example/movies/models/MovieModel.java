package com.example.movies.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name="movie")
@Table(name="movies")
@Getter
@Setter
@AllArgsConstructor
public class MovieModel {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private int year;
    private float rating;
    private String image;
}
