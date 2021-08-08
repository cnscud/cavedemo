# 脚手架

## 涵盖功能:
* > 使用Zookeeper作为注册中心
* > 数据库操作MyBatis
* > 自定义配置: Zookeeper
* > 缓存操作 Redis  
* > 队列操作 Kafka: Producer, Consumer
* > MyBatis配置存到Zookeeper, 支持动态修改数据库
* > 用户登录授权
* > 模版: Freemarker支持
* > 页面渲染: 用户, 博客内容  
* 使用网关: 熔断 降级?  

* 前端相关: Vue/React, 以及打包



## Todo

* > Freemarker: substring
* > jackson: 日期配置 序列化
* > Logo生成网站
* > Mybatis 支持多数据源:
* Exception Handler
  
* Feign + Rest: 如何更简洁优雅使用Feign服务?
* 
* 学习MyBatis事务配置?
* 优化数据库配置

* 清理Maven依赖
* 文档: 环境准备
* 数据: 整理到文件



## 相关工具
    代码生成:  Free Mybatis Plugin (Idea) 或 Mybatis Generate (Maven插件)
    Zookeeper本地GUI工具:  PrettyZoo https://zhuanlan.zhihu.com/p/353163620
    Redis 桌面: https://github.com/qishibo/AnotherRedisDesktopManager/releases
    
## 运行环境准备
    启动Zookeeper, 如果不是本机, 则设置"ZK_HOSTS"环境变量

    普通Mysql示例, 请修改application.yml里面相关的数据库配置
    配置中心版Mysql示例, 如果不是本机, 需要修改zookeeper配置
    导入用户和数据: config/mysql

    启动Redis, 参见config/zookeeper/redis* , 如果不一致请修改配置文件
    启动Kafka, 如果不是本机请修改zookeeper配置

    导入更新后的数据: config/zookeeper

## 应用启动顺序
    微服务 ms-fundmain-service
    网关 ms-gateway
    消息消费 mqconsumer
    用户端 web



