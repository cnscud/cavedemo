# 脚手架
* 此项目是一个基于Spring Cloud 2020版本的快速脚手架, 使用了微服务和网关, 用于中小公司搭建项目. 
* 使用了Spring Cloud Gateway, Mybatis, Zookeeper, Freemarker, Redis, Kafka, JWT等技术.

## 涵盖功能:
* > 使用Zookeeper作为注册中心
* > 数据库操作MyBatis
* > @自定义配置中心: Zookeeper
* > 缓存操作 Redis  
* > 队列操作 Kafka: Producer, Consumer
* > @@@ MyBatis配置存到Zookeeper, 支持动态修改数据库
* > @用户登录授权: 使用JWT, Cookie
* > 模版渲染: Freemarker支持, 适合做SEO.
* > @@@ 集成网关: 熔断 降级等网关特性  


## Todo 记录
* > Freemarker: substring
* > jackson: 日期配置 序列化
* > Logo生成网站
* > Mybatis 支持多数据源:
* > Web Exception Handler
* > 简单事务实践
* > 文档: 环境准备
* > 数据: 整理数据文件, 让页面看起来有内容.
* > 注册中心 Zookeeper 地址: zookeeper.connect-string 可以使用环境变量


## 可优化点
* 为了演示方便, 可以引入docker-compose构建?
* 配置 redis-rate-limiter, redis地址放在Zookeeper里
* JWT服务应该放在微服务里?
* Feign + Rest: 如何更简洁优雅使用Feign服务?
* 前端相关: 引入React/Vue, 以及前端打包
* 如果多个WEB项目, 工具类(Utils, Helper)提取到公用模块


## 模块说明
    cavedemo-root: 依赖管理
    ms-fundmain
        ms-fundmain-base: 基础服务 - 原型模块
        ms-fundmain-service: 基础服务 - 微服务实现
    mq-consumers 消息消费
    ms-gateway 网关
    web 用户WEB


## 相关工具
    代码生成:  Free Mybatis Plugin (Idea) 或 Mybatis Generate (Maven插件)
    Zookeeper本地GUI工具:  PrettyZoo https://zhuanlan.zhihu.com/p/353163620
    Redis 桌面: https://github.com/qishibo/AnotherRedisDesktopManager/releases
    Logo网站: https://www.designevo.com/cn/logo-maker/
    
## 运行环境准备
    1. 启动Zookeeper, 如果不是本机, 则设置"ZK_HOSTS"环境变量
        配置举例: ZK_HOSTS=127.0.0.1:2181

    2. 启动Mysql & 配置
        (已移除)普通Mysql示例, 请修改application.yml里面相关的数据库配置
        配置中心版Mysql配置: mysql.cavedemo.conf , 如果不是本机, 需要修改zookeeper配置
    
        导入用户和数据: config/mysql
            scheme.sql: 创建用户和Database
            cavedemo.sql: 演示数据

    3. 启动Redis 
        参见config/zookeeper/redis* , 如果不一致请修改配置文件
        使用redis的 utils/create-cluster 可以快速创建一个cluster

        本项目: redis://127.0.0.1:6580 redis://127.0.0.1:6581 redis://127.0.0.1:6582

    4. (可选) 启动Kafka, 如果不是本机请修改zookeeper配置
        127.0.0.1:9092

    5. 导入更新后的数据: config/zookeeper
        查看并运行 init.sh 导入zookeeper配置

    6. 配置域名
        因为使用Cookie保存用户信息, 可以设置域名为 demo.cnscud.com , 需要自己配置hosts

## 应用启动顺序
    (准备好环境)
    微服务 ms-fundmain-service
    网关 ms-gateway
    消息消费 mqconsumer (可选)
    用户端 web : 调试方式启动 spring-boot:run -Dspring-boot.run.fork=false

    访问: http://demo.cnscud.com:8000/

## 默认用户
    felix, 密码 abc123


