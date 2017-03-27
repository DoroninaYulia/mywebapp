/*CREATE DATABASE userDB;*/
USE userDB;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id       INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name     VARCHAR(50),
  lastname VARCHAR(50),
  city     VARCHAR(50),
  email    VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO users VALUES (NULL, 'nickDB', 'dallsDB', 'dniproDB', 'ser@gmail.comDB');
INSERT INTO users VALUES (NULL, 'nickDB', 'dallsDB', 'dniproDB', 'use@gmail.comDB');
INSERT INTO users VALUES (NULL, 'nickDB', 'dallsDB', 'dniproDB', 'user@gmail.comDB');
INSERT INTO users VALUES (NULL, 'nickDB', 'dallsDB', 'dniproDB', 'uer@gmail.comDB');

SELECT *FROM users;
