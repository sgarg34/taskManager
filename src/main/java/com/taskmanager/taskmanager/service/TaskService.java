package com.taskmanager.taskmanager.service;


import com.taskmanager.taskmanager.entity.Task;
import com.taskmanager.taskmanager.enums.TaskStatus;
import com.taskmanager.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.taskmanager.repository.TaskRepository;
import com.taskmanager.taskmanager.dto.TaskRequestDto;
import com.taskmanager.taskmanager.dto.TaskResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public TaskResponseDto createTask(TaskRequestDto request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());
        Task saved = repository.save(task);
        TaskResponseDto response = new TaskResponseDto();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setStatus(saved.getStatus());
        response.setPriority(saved.getPriority());
        response.setDueDate(saved.getDueDate());
        return response;
    }

    public TaskResponseDto getTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        TaskResponseDto response = new TaskResponseDto();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setPriority(task.getPriority());
        response.setDueDate(task.getDueDate());
        return response;
    }
}