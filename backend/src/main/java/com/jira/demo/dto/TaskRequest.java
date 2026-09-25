package com.jira.demo.dto;

import com.jira.demo.entity.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequest(
        @NotBlank(message = "Need title")
        @Size(max=200,message="title must be at most 200 character")
        String title,
        String description,
        @NotNull(message = "Priority is required")
        TaskPriority priority
) {
}
