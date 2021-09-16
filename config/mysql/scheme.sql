# 已经改成由容器自己创建, 所以本SQL仅供参考.
CREATE DATABASE IF NOT EXISTS `cavedemo` DEFAULT COLLATE = `utf8mb4_general_ci`;


CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'dbuser'@'%' IDENTIFIED BY 'password';
GRANT all privileges ON cavedemo.* TO 'dbuser'@'%'
