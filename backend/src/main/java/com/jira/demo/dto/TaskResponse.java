package com.jira.demo.dto;

import com.jira.demo.entity.Task;
import com.jira.demo.entity.TaskPriority;
import com.jira.demo.entity.TaskStatus;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        TaskPriority priority,
        Long projectId
) {
    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getProject().getId()
        );
    }
}
