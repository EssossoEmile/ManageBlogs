CREATE DATABASE IF NOT EXISTS restapi;

USE restapi;

CREATE TABLE IF NOT EXISTS blog (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  content VARCHAR(5000) NOT NULL
);

INSERT INTO `blog` (`title`, `content`) VALUES
('About Java', 'Java apps are the most popular robust app in the world.');
INSERT INTO `blog` (`title`, `content`) VALUES
('About PHP', 'We can build a solid back end app with PHP.');
INSERT INTO `blog` (`title`, `content`) VALUES
('About Javascript', 'Is the more slight language wa can use for the simple app.');
INSERT INTO `blog` (`title`, `content`) VALUES
('About Html', 'Iis a web language that help to build views.');
INSERT INTO `blog` (`title`, `content`) VALUES
('About Css', 'Just for the views style.');

CREATE TABLE IF NOT EXISTS user (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  email VARCHAR(500) NOT NULL
);

INSERT INTO `user` (`name`, `email`) VALUES
('Essosso Belinga Emile', 'emile.essosso@gmail.com');
INSERT INTO `user` (`name`, `email`) VALUES
('Rocco Emile', 'roccoemileessos@yahoo.fr');

