FROM mysql:5.7

LABEL OG=cnscud.com

ADD mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf


ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

## 如果使用Docker Compose, 则可以直接mount, 不需要copy
#COPY ./sql /opt/sql/
#COPY ./init/init.sql /docker-entrypoint-initdb.d

