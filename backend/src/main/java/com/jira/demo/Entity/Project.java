package com.jira.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Projects")
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(name = "project_key", nullable = false, unique = true, length = 10)
    private String projectKey;

}
