CREATE DATABASE IF NOT EXISTS `cavedemo` DEFAULT COLLATE = `utf8mb4_general_ci`;


CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'dbuser'@'%' IDENTIFIED BY 'password';
GRANT all privileges ON cavedemo.* TO 'dbuser'@'%'
