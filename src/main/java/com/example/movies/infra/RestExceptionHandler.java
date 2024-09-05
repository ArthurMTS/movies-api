package com.example.movies.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ExceptionPayload> movieNotFound(EntityNotFoundException e) {
        var notFound = HttpStatus.NOT_FOUND;
        var payload = new ExceptionPayload(e.getMessage(), notFound);
        return ResponseEntity.status(notFound).body(payload);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<ExceptionPayload> methodMismatch(MethodArgumentTypeMismatchException e) {
        var badRequest = HttpStatus.BAD_REQUEST;
        var payload = new ExceptionPayload(e.getMessage(), badRequest);
        return ResponseEntity.status(badRequest).body(payload);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<ExceptionPayload> resourceNotFound(NoResourceFoundException e) {
        var notFound = HttpStatus.NOT_FOUND;
        var payload = new ExceptionPayload(e.getMessage(), notFound);
        return ResponseEntity.status(notFound).body(payload);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ExceptionPayload> jsonParseError(HttpMessageNotReadableException e) {
        var badRequest = HttpStatus.BAD_REQUEST;
        var payload = new ExceptionPayload(e.getMessage(), badRequest);
        return ResponseEntity.status(badRequest).body(payload);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ExceptionPayload> argumentNotValid(MethodArgumentNotValidException e) {
        var badRequest = HttpStatus.BAD_REQUEST;
        String title = Objects.requireNonNull(e.getFieldError()).getField();
        String error = e.getFieldError().getDefaultMessage();
        String message = String.format("%s: %s", title, error);
        var payload = new ExceptionPayload(message, badRequest);
        return ResponseEntity.status(badRequest).body(payload);
    }
}
