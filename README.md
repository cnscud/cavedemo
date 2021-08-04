# 脚手架

## 涵盖功能:
* > 使用Zookeeper作为注册中心
* > 数据库操作MyBatis
* > 自定义配置: Zookeeper
* > 缓存操作 Redis
  
* 队列操作 Kafka: Producer, Consumer
* 
* MyBatis配置存到Zookeeper
* 
* 用户登录授权
* 模版: Freemarker支持

* 需要的配套: Vue/React, 以及打包

## 相关工具
    代码生成:  Free Mybatis Plugin (Idea) 或 Mybatis Generate (Maven插件)
    Zookeeper本地GUI工具:  PrettyZoo https://zhuanlan.zhihu.com/p/353163620
    
## 运行环境准备
    启动Zookeeper, 如果不是本机, 则设置"ZK_HOSTS"环境变量

    启动Mysql, 如果不是本机, 请修改application.yml
    导入用户和数据: config/mysql
    自动配置版Mysql, 如果不是本机, 需要修改zookeeper配置

    启动Redis, 端口xxxx, 如果不是请修改zookeeper配置
    启动Kafka, 如果不是本机请修改zookeeper配置

    导入更新后的数据: config/zookeeper

## 应用启动顺序
    微服务 ms-fundmain-service
    网关 ms-gateway
    用户端 web
    消息消费 mqconsumer


## Todo
* > Mybatis 支持多数据源:
* 学习MyBatis事务配置?
* 优化数据库配置

* 清理Maven依赖
* 文档: 环境准备
* 数据: 整理到文件

* ZkClient升级 以后再说...目标  



