package com.example.movies.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieDTO(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull int year,
        @NotNull float rating,
        @NotBlank String image
) {}
