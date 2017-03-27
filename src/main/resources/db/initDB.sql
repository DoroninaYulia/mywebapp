DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  lastname VARCHAR(50),
  city VARCHAR(50),
  email VARCHAR(50) UNIQUE
);

INSERT INTO users VALUES (NULL, 'nick', 'dalas', 'dnipro', 'user@gmail.com');
INSERT INTO users VALUES (NULL, 'angela', 'hike', 'kyiv', 'ang@yahoo.com');

SELECT *FROM users;
