运行环境&配置文件

1. 构建 Mysql镜像
   cd mysql
   docker build -t cnscud/cavedemo-mysql:1.0 .

2. Zookeeper改用 依赖其他项目的镜像, 不再使用本目录下的镜像

