#!/bin/sh

##
## 手工导入, 依赖python脚本 zk
##

zk create /xpower ""
zk list /xpower/

zk create /xpower/cache ""
zk create /xpower/config ""
zk create /xpower/dbn ""


zk create /xpower/cache/redis.test redis.test.conf
zk create /xpower/cache/redis.cluster.test redis.cluster.test.conf
zk create /xpower/config/kafka kafka.conf
zk create /xpower/dbn/cavedemo mysql.cavedemo.conf


zk set /xpower/cache/redis.test redis.test.conf
zk set /xpower/cache/redis.cluster.test redis.cluster.test.conf
zk set /xpower/config/kafka kafka.conf
zk set /xpower/dbn/cavedemo mysql.cavedemo.conf

