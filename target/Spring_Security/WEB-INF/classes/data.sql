
INSERT INTO users
VALUES (1, 'admin', 'admin');

INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_roles
VALUES (1, 2);