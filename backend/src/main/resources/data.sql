DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users_teams;


create table teams (
  id        BIGINT AUTO_INCREMENT,
  name      VARCHAR(255) NOT NULL,
  CONSTRAINT teams_PK PRIMARY KEY (id),
  CONSTRAINT teams_name_UQ UNIQUE (name)
);

create table roles (
  id        BIGINT AUTO_INCREMENT,
  name      VARCHAR(255) NOT NULL,
  CONSTRAINT roles_PK PRIMARY KEY (id),
  CONSTRAINT roles_name_UQ UNIQUE (name)
);

create table users (
  id             BIGINT AUTO_INCREMENT,
  first_name     VARCHAR(255) NOT NULL,
  last_name      VARCHAR(255) NOT NULL,
  days_left      INT DEFAULT 0,
  days_used      INT DEFAULT 0,
  CONSTRAINT users_PK PRIMARY KEY (id)
);

create table images (
  user_id         BIGINT,
  image_data      BLOB,
  CONSTRAINT images_PK PRIMARY KEY (user_id),
  CONSTRAINT images_users_FK FOREIGN KEY (user_id) REFERENCES users
);

create table users_teams (
  user_id         BIGINT,
  team_id         BIGINT,
  CONSTRAINT users_teams_PK PRIMARY KEY (user_id, team_id),
  CONSTRAINT users_teams_UQ UNIQUE (user_id, team_id),
  CONSTRAINT users_teams_users_FK FOREIGN KEY (user_id) REFERENCES users,
  CONSTRAINT users_teams_teams_FK FOREIGN KEY (team_id) REFERENCES teams
);

create table users_roles (
  user_id         BIGINT,
  role_id         BIGINT,
  CONSTRAINT users_roles_PK PRIMARY KEY (user_id, role_id),
  CONSTRAINT users_roles_UQ UNIQUE (user_id, role_id),
  CONSTRAINT users_roles_users_FK FOREIGN KEY (user_id) REFERENCES users,
  CONSTRAINT users_roles_roles_FK FOREIGN KEY (role_id) REFERENCES roles
);

INSERT INTO roles VALUES (1, 'BACK END DEVELOPER'), (2, 'FRONT DEVELOPER'), (3, 'QUALITY ASSURANCE'), (4, 'PROJECT MANAGER');
INSERT INTO teams VALUES (1, 'Main Team'), (2, 'Payment Team'), (3, 'Integration Team');