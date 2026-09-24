package com.jira.demo.dto;

import com.jira.demo.entity.Project;

public record ProjectResponse(
    Long id,
    String name,
    String projectKey
) {
    public static ProjectResponse from(Project project) {

        return new ProjectResponse(
            project.getId(),
            project.getName(),
            project.getProjectKey()
        );
    }
}
