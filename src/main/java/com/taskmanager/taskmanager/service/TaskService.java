package com.taskmanager.service;

import com.taskmanager.dto.TaskRequestDto;
import com.taskmanager.dto.TaskResponseDto;
import com.taskmanager.entity.Task;
import com.taskmanager.enums.TaskStatus;
import com.taskmanager.exception.TaskNotFoundException;
import com.taskmanager.repository.TaskRepository;
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
        task.setTitle(request.title);
        task.setDescription(request.description);
        task.setStatus(request.status);
        task.setPriority(request.priority);
        task.setDueDate(request.dueDate);
        Task saved = repository.save(task);
        TaskResponseDto response = new TaskResponseDto();
        response.id = saved.getId();
        response.title = saved.getTitle();
        response.description = saved.getDescription();
        response.status = saved.getStatus();
        response.priority = saved.getPriority();
        response.dueDate = saved.getDueDate();
        return response;
    }

    public TaskResponseDto getTask(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        TaskResponseDto response = new TaskResponseDto();
        response.id = task.getId();
        response.title = task.getTitle();
        response.description = task.getDescription();
        response.status = task.getStatus();
        response.priority = task.getPriority();
        response.dueDate = task.getDueDate();
        return response;
    }
}