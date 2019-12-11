CREATE DATABASE IF NOT EXISTS restapi;

USE restapi;

CREATE TABLE IF NOT EXISTS user (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  email VARCHAR(500) NOT NULL
);

INSERT INTO user VALUES (null, 'Essosso Belinga Emile', 'emile.essosso@gmail.com');
INSERT INTO user VALUES (null, 'Rocco Emile', 'roccoemileessos@yahoo.fr');

CREATE TABLE IF NOT EXISTS blog (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  content VARCHAR(5000) NOT NULL,
  userid INT(6) UNSIGNED NOT NULL,
  FOREIGN KEY (userid) REFERENCES user(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO blog VALUES (null, 'About Java', 'Java apps are the most popular robust app in the world.', 1);
INSERT INTO blog VALUES (null, 'About PHP', 'We can build a solid back end app with PHP.', 1);
INSERT INTO blog VALUES (null, 'About Javascript', 'Is the more slight language wa can use for the simple app.', 1);
INSERT INTO blog VALUES (null, 'About Html', 'Iis a web language that help to build views.', 2);
INSERT INTO blog VALUES (null, 'About Css', 'Just for the views style.', 1);



