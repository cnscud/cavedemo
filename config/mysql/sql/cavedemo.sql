# ************************************************************
# Sequel Pro SQL dump
# Version 5446
#
# https://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 8.0.24)
# Database: cavedemo
# Generation Time: 2021-08-12 12:21:04 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table blog
# ------------------------------------------------------------

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `user_id` int NOT NULL COMMENT '用户',
                        `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                        `thumbnail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '缩略图',
                        `summary` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '摘要',
                        `content` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '内容',
                        `created_at` datetime NOT NULL COMMENT '创建时间',
                        `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;

INSERT INTO `blog` (`id`, `user_id`, `title`, `thumbnail`, `summary`, `content`, `created_at`, `updated_at`)
VALUES
    (1001,1000,'Dubbo 实现一个Route Factory(用于灰度发布)','','我们实现一个Route Factory, 它会根据参数中的workzone来选择合适的Invoker实例, 可以实现一定程度上的灰度发布.','博客内容','2021-08-02 00:00:00','2021-08-12 17:39:02'),
    (1002,1000,'Spring Cloud分区发布实践(4) FeignClient','','我们使用FeignClient来调用微服务, 就可以配合LoadBalancer实现按区域调用.','博客内容 1002','2021-08-03 00:00:00','2021-08-12 17:39:29'),
    (1003,1001,'MyBatis使用Zookeeper保存数据库的配置,可动态刷新','','MyBatis使用Zookeeper保存数据库的动态配置','博客内容 1003','2021-08-03 13:00:00','2021-08-12 17:39:55'),
    (1004,1000,'技术小组长管理模版','','对于初级管理者来说, 经常会出现时间碎片化, 关键事项抓不住的情况, 此时我们可以试着推行”标准管理模版”.','博客内容','2021-08-12 00:00:00','2021-08-12 17:43:38'),
    (1005,1000,'标准的开发上线流程和重要窗口','','一个标准的开发上线流程&重要窗口&支撑工具','c','2021-08-12 00:00:00','2021-08-12 17:41:41'),
    (1006,1000,'如何移动和缩放一个无边框窗口','','无边界窗口需要自己来处理窗口管理','c','2021-08-12 00:00:00','2021-08-12 17:42:04'),
    (1007,1000,'修改Eureka的metadata脚本','','修改Eureka的metadata脚本','c','2021-08-12 00:00:00','2021-08-12 17:42:56');

/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int unsigned NOT NULL AUTO_INCREMENT,
                        `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录名',
                        `salt` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'Salt',
                        `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '混淆后的密码',
                        `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
                        `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '个人介绍',
                        `created_at` datetime NOT NULL COMMENT '创建时间',
                        `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `salt`, `password`, `name`, `introduce`, `created_at`, `updated_at`)
VALUES
    (1000,'felix','abc','8262e062cfc7cb6ab11bf4eb43fe7c8d','路人甲','一个技术开发者','2021-08-02 00:00:00','2021-08-12 17:51:18'),
    (1001,'rosa','bb','ddd','李宁','著名体育品牌','2021-08-03 00:00:00','2021-08-12 17:38:01');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
