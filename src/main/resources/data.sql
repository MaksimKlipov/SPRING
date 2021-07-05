-- Table: users
CREATE TABLE IF NOT EXISTS users (
                       id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
)
    ENGINE = InnoDB;

-- Table: roles
CREATE TABLE IF NOT EXISTS roles (
                       id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL
)
    ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE IF NOT EXISTS users_roles (
                            users_id INT NOT NULL,
                            roles_id INT NOT NULL,

                            FOREIGN KEY (users_id) REFERENCES users (id),
                            FOREIGN KEY (roles_id) REFERENCES roles (id),

                            UNIQUE (users_id, roles_id)
)
    ENGINE = InnoDB;

-- Insert data
INSERT INTO users
VALUES (1, 'admin', '$2a$10$jvU71uE2F.jth5atezEWLeXURSTfpzqxXepwloUavC1yQvkV7EA0W');

INSERT INTO roles
VALUES (1, 'ROLE_USER');
INSERT INTO roles
VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_roles
VALUES (1, 2);