CREATE TABLE users (
                       id          BIGSERIAL PRIMARY KEY,
                       name        VARCHAR(100) NOT NULL,
                       email       VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE projects (
                          id           BIGSERIAL PRIMARY KEY,
                          name         VARCHAR(150) NOT NULL,
                          project_key  VARCHAR(10)  NOT NULL UNIQUE
);

CREATE TABLE tasks (
                       id           BIGSERIAL PRIMARY KEY,
                       title        VARCHAR(200) NOT NULL,
                       description  TEXT,
                       status       VARCHAR(20)  NOT NULL DEFAULT 'TODO',
                       priority     VARCHAR(20)  NOT NULL DEFAULT 'MEDIUM',
                       project_id   BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE
);

CREATE INDEX idx_tasks_project_id ON tasks(project_id);