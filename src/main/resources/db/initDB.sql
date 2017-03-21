DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  lastname VARCHAR(50),
  city VARCHAR(50),
  email VARCHAR(50)
);

INSERT INTO users VALUES(NULL, "nickDB", "dallsDB", "dniproDB", "user@gmail.comDB");
INSERT INTO users VALUES(NULL , "angelaDB", "hikeDB", "kyivDB", "ang@yahoo.comDB");
INSERT INTO users VALUES(NULL , "nickDB", "hikeDB", "kyivDB", "userang@yahoo.comDB");

SELECT *FROM users;
