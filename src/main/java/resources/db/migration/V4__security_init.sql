CREATE TABLE users (
  id       BIGSERIAL    NOT NULL  PRIMARY KEY,
  username VARCHAR      NOT NULL,
  password VARCHAR NOT NULL
);

CREATE TABLE roles (
  id   BIGSERIAL    NOT NULL  PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE user_roles (
  user_id INT NOT NULL REFERENCES users,
  role_id INT NOT NULL REFERENCES roles
);

INSERT INTO users (username, password) VALUES ('admin', '$2a$10$EH8KarosKrTIpBnuQieXDuxL4y3WB2asz9XLZJ7/x0lDyfeXeR3ue');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO user_roles (user_id, role_id) VALUES (1,1);

INSERT INTO users (username, password) VALUES ('user', '$2a$10$EH8KarosKrTIpBnuQieXDuxL4y3WB2asz9XLZJ7/x0lDyfeXeR3ue');
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO user_roles (user_id, role_id) VALUES (2,2);