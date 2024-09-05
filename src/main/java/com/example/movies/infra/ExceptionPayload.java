package com.example.movies.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ExceptionPayload {
    private String message;
    private HttpStatus httpStatus;
}
