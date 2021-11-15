#!/bin/sh

##
## 手工导入, 依赖python脚本 zk
## python3 需要安装kazoo依赖包
## 请谨慎使用, 仅用于手动验证操作.
##

zk create /xpower ""
zk list /xpower/

zk create /xpower/cache ""
zk create /xpower/config ""
zk create /xpower/dbn ""


zk create /xpower/cache/redis.test init.data/redis.test.conf
zk create /xpower/cache/redis.cluster.test init.data/redis.cluster.test.conf
zk create /xpower/config/kafka init.data/kafka.conf
zk create /xpower/dbn/cavedemo init.data/mysql.cavedemo.conf
zk create /xpower/config/cavedemo/test "hello"

## 方便覆盖, 注意会覆盖数据
zk set /xpower/cache/redis.test init.data/redis.test.conf
zk set /xpower/cache/redis.cluster.test init.data/redis.cluster.test.conf
zk set /xpower/config/kafka init.data/kafka.conf
zk set /xpower/dbn/cavedemo init.data/mysql.cavedemo.conf
zk set /xpower/config/cavedemo/test "hello"
