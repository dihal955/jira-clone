package com.jira.demo.Service;

import com.jira.demo.dto.ProjectRequest;
import com.jira.demo.dto.ProjectResponse;
import com.jira.demo.entity.Project;
import com.jira.demo.exception.DuplicateResourceException;
import com.jira.demo.exception.ResourceNotFoundException;
import com.jira.demo.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectResponse create(ProjectRequest request) {
        if (projectRepository.existsByProjectKey(request.projectKey())) {
            throw new DuplicateResourceException("Project key already exists: " + request.projectKey());
        }
        Project project = new Project();
        project.setName(request.name());
        project.setProjectKey(request.projectKey());
        return ProjectResponse.from(projectRepository.save(project));
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> findAll() {
        return projectRepository.findAll().stream().map(ProjectResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public ProjectResponse findById(Long id) {
        return ProjectResponse.from(getOrThrow(id));
    }

    @Transactional
    public ProjectResponse update(Long id, ProjectRequest request) {
        Project project = getOrThrow(id);
        boolean keyChanged = !project.getProjectKey().equals(request.projectKey());
        if (keyChanged && projectRepository.existsByProjectKey(request.projectKey())) {
            throw new DuplicateResourceException("Project key already exists: " + request.projectKey());
        }
        project.setName(request.name());
        project.setProjectKey(request.projectKey());
        return ProjectResponse.from(project);
    }

    @Transactional
    public void delete(Long id) {
        projectRepository.delete(getOrThrow(id));
    }

    private Project getOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found: " + id));
    }
}
