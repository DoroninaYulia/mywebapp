DROP TABLE IF EXISTS users_role;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  lastname VARCHAR(50),
  city VARCHAR(50),
  email VARCHAR(50) UNIQUE,
  password VARCHAR(50),
  enabled BOOLEAN DEFAULT TRUE
);

INSERT INTO users VALUES (NULL, 'nick', 'dalas', 'dnipro', 'user@gmail.com', '123', DEFAULT );
INSERT INTO users VALUES (NULL, 'angela', 'hike', 'kyiv', 'ang@yahoo.com', '321', DEFAULT );

CREATE TABLE users_role(
role VARCHAR(50),
user_id INTEGER,
FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users_role VALUES('ROLE_USER', 1);
INSERT INTO users_role VALUES('ROLE_ADMIN', 2);
INSERT INTO users_role VALUES('ROLE_ADMIN', 1);

SELECT *FROM users;
SELECT *FROM users_role;
