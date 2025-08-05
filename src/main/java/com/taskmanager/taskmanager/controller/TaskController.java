package com.taskmanager.controller;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@Valid @RequestBody TaskRequestDto request) {
        return ResponseEntity.status(201).body(service.createTask(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTask(id));
    }
}