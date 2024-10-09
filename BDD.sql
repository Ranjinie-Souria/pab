-- Suppression BDD si existe
DROP DATABASE IF EXISTS pab;

-- Création de la base de données
CREATE DATABASE pab;
USE pab;

-- Création de la table Formation
CREATE TABLE formation (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    PRIMARY KEY (id)
);

-- Création de la table Users
CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    user_type VARCHAR(50) NOT NULL,
    update_date TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (formation_id) REFERENCES formation(id)
);

-- Création de la table UserFormations
CREATE TABLE user_formations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    formation_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (formation_id) REFERENCES formation(id)
);

-- Création de la table Course
CREATE TABLE course (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    date TIMESTAMP NOT NULL,
    formation_id INT NOT NULL,
    room_nb INT,
    duration INT NOT NULL,
    deleted_date TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (formation_id) REFERENCES formation(id)
);

-- Création de la table Attendance
CREATE TABLE attendance (
    id INT NOT NULL AUTO_INCREMENT,
    course_id INT NOT NULL,
    date TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    status CHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

-- Création de la table Document
CREATE TABLE document (
    id INT NOT NULL AUTO_INCREMENT,
    name CHAR(50) NOT NULL,
    url CHAR(50) NOT NULL,
    date TIMESTAMP NOT NULL,
    course_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);
