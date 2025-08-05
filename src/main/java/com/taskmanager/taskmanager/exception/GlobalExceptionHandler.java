package com.taskmanager.taskmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(com.taskmanager.exception.TaskNotFoundException.class)
    public ResponseEntity<String> handleNotFound(com.taskmanager.exception.TaskNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}