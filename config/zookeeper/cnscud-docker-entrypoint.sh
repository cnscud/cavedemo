#!/bin/bash
## script for support import data with zookeeper
## author: felix zhang 2021.8.22
## please make sure the file 755

# set -e

initedfile="/data/zk.cnscud.inited"
initcmdfile='/init.data/import.data.zk.sh'

needcallinit="Y"

#
if [ ! -f "$initedfile" ]
then
  needcallinit="Y${needcallinit}"
else
  echo "[cnscud] data had inited, will not init again."
fi

if [ -f "$initcmdfile" ]
then
  needcallinit="Y${needcallinit}"
else
  echo "[cnscud] not found script for init data, skip."
fi

echo "check needcallinit is: $needcallinit"

## start my import data ====================
if [ $needcallinit = "YYY" ]
then

  ## start in backgroup by original entry point
  /docker-entrypoint.sh zkServer.sh start

  ## waiting for zookeeper
  sleep 10

  echo "[cnscud] call init data now..."
  date > "$initedfile"

  ##import data
  sh $initcmdfile >> $initedfile

  /docker-entrypoint.sh zkServer.sh stop

  ## mark
  echo "[cnscud] mark: init was finished!"
  date >> "$initedfile"
  echo "done" >> "$initedfile"
fi

## end my import data ====================


echo "[cnscud] Starting Zookeeper in foreground mode..."
/docker-entrypoint.sh $@
