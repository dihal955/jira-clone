package com.jira.demo.Repository;

import com.jira.demo.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
          boolean existsByProjectKey(String projectKey);



}
