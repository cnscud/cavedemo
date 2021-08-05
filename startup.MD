Spring Cloud 脚手架
(此文件仅用于记录思考)

应用模块:
	WEB1: 用户端
	WEB2: 管理后台
	前端网关1: 用户端网关
	管理后台网关2: 管理后台
	微服务: 服务1, 服务2....


技术栈:
	Zookeeper: 配置中心, 注册中心
	MyBatis: 数据库, 配置-> 配置中心

	缓存
	队列
	认证: JWT? OAuth2?


考虑的特性:
	Gateway? 如何拆分细粒度?
	灰度发布


打包支持
	docker

===========================

用户端的缺省模块:
	WEB: Freemarker, 或前后端分离
    网关: 限流, 鉴权?
    微服务: Rest/Dubbo
    POM Parent

    Utils
    底层封装: redis, 配置中心, mq, DB数据源

    认证: Shiro + OAuth2?

  	Zookeeper/Nacos 配置中心: XPower
  	Redis + Zookeeper? 封装动态配置 : XPower
  	Kafka + Zookeeper? 封装动态配置 : 扩展XPower todo
  	Mysql + Mybatis + Zookeeper    封装动态配置 todo



============================


常见部署方式
  动态读取配置: zookeeper
  写在配置文件里, 根据profile分多个, 部署时根据profile过滤
