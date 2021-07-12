-- Insert data
INSERT INTO users
VALUES (1, 25, 'klipov@mail.ru', 'Klipov', '$2a$10$jvU71uE2F.jth5atezEWLeXURSTfpzqxXepwloUavC1yQvkV7EA0W', '2', 'Maksim');

INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_roles
VALUES (1, 2);