#!/bin/bash

## for init zookeeper data, you need update this file
## author: felix zhang 2021.8.22
## please make sure the file 755


CMD=`which zkCli.sh`
find="1"
if [ -z $CMD ]
then
	find="0"
fi

if [ $find = "0" ]
then
	CMD="$ZK_HOME/bin/zkCli.sh"
fi

echo $CMD

if [-z $CMD ]
then
  echo "not found zkCli.sh, please check!!!"
  exit 1
fi


$CMD  create /xpower "1"
$CMD  create /xpower/cache "1"
$CMD  create /xpower/config "1"
$CMD  create /xpower/dbn "1"

$CMD  create /xpower/cache/redis.test "`cat /cnscud/redis.test.conf`"
$CMD  create /xpower/config/kafka "`cat /cnscud/kafka.conf`"
$CMD  create /xpower/dbn/cavedemo "`cat /cnscud/mysql.cavedemo.conf`"
