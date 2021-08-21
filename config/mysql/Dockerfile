FROM mysql:5.7

LABEL OG=cnscud.com

ADD mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf

## 如果使用Docker Compose, 则可以直接mount, 不需要copy
#COPY ./sql /opt/sql/
#COPY ./init/init.sql /docker-entrypoint-initdb.d

