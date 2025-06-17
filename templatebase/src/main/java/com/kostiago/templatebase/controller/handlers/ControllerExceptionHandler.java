package com.kostiago.templatebase.controller.handlers;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kostiago.templatebase.record.exceptions.CustomError;
import com.kostiago.templatebase.record.exceptions.FieldMessage;
import com.kostiago.templatebase.record.exceptions.ValidationError;
import com.kostiago.templatebase.service.exceptions.DatabaseException;
import com.kostiago.templatebase.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), "Resource not found: " + e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseException(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), "Database error: " + e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValid(MethodArgumentNotValidException e,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        List<FieldMessage> errors = e.getBindingResult().getFieldErrors().stream()
                .map(err -> new FieldMessage(err.getField(), err.getDefaultMessage()))
                .toList();

        ValidationError err = new ValidationError(
                Instant.now(),
                status.value(),
                "Validation error:",
                request.getRequestURI(),
                errors);

        return ResponseEntity.status(status).body(err);
    }
}
