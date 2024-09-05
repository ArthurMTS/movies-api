package com.example.movies.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieDTO(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull int year,
        @NotNull @DecimalMax("10.00") @DecimalMin("0.00") float rating,
        @NotBlank String image
) {}
