ALTER TABLE users ADD COLUMN password_hash VARCHAR(255) NOT NULL DEFAULT '';
ALTER TABLE users ADD COLUMN role VARCHAR(20) NOT NULL DEFAULT 'USER';
ALTER TABLE users ALTER COLUMN password_hash DROP DEFAULT;

CREATE TABLE project_members (
                                 project_id  BIGINT NOT NULL REFERENCES projects(id) ON DELETE CASCADE,
                                 user_id     BIGINT NOT NULL REFERENCES users(id)    ON DELETE CASCADE,
                                 role        VARCHAR(20) NOT NULL DEFAULT 'MEMBER',
                                 PRIMARY KEY (project_id, user_id)
);

CREATE INDEX idx_project_members_user_id ON project_members(user_id);