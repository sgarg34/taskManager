package com.taskmanager.dto;

import com.taskmanager.enums.Priority;
import com.taskmanager.enums.TaskStatus;

import java.time.LocalDate;

public class TaskRequestDto {
    public String title;
    public String description;
    public TaskStatus status;
    public Priority priority;
    public LocalDate dueDate;
}