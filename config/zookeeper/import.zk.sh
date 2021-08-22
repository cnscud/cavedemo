#!/bin/bash

## for init zookeeper data, you need update this file
## author: felix zhang 2021.8.22
## please make sure the file 755


cd $ZK_HOME

./bin/zkCli.sh create /xpower "1"
./bin/zkCli.sh create /xpower/cache "1"
./bin/zkCli.sh create /xpower/config "1"
./bin/zkCli.sh create /xpower/dbn "1"

./bin/zkCli.sh create /xpower/cache/redis.test "`cat /cnscud/redis.test.conf`"
./bin/zkCli.sh create /xpower/config/kafka "`cat /cnscud/kafka.conf`"
./bin/zkCli.sh create /xpower/dbn/cavedemo "`cat /cnscud/mysql.cavedemo.conf`"
