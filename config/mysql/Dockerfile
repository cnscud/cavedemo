#
# target image name: cnscud/cavedemo-mysql5
#
FROM mysql:5.7

LABEL OG=cnscud.com

ADD mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf


ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

## 如果使用Docker Compose, 则可以直接mount, 不需要copy
## 此处为了兼容k8s部署, 把原始数据初始化放到image里了.
## 实际场景不需要初始化业务数据, 或者手工初始化即可.
COPY ./sql /opt/sql/
COPY ./init/init.sql /docker-entrypoint-initdb.d

