#!/bin/bash
## script for support import data with zookeeper
## author: felix zhang 2021.8.22
## please make sure the file 755


## start my import data ====================
initedfile="/data/cnscud.inited"
if [ ! -f "$initedfile" ]; then

  ## start in backgroup by original entry point
  /docker-entrypoint.sh zkServer.sh start

  ## waiting for zookeeper
  sleep 3

  echo "[cnscud] call init data now..."
  ##import data
  sh /cnscud/import.zk.sh

  /docker-entrypoint.sh zkServer.sh stop

  ## mark
  echo "[cnscud] mark: init was finished!"
  touch "$initedfile"
else
  echo "[cnscud] data had inited, will not init again."
fi

## end my import data ====================


echo "[cnscud] Starting Zookeeper in foreground mode..."
/docker-entrypoint.sh $@
