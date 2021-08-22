#!/bin/bash
## script for support import data with zookeeper
## author: felix zhang 2021.8.22
## please make sure the file 755

sed -i -r 's|#(log4j.appender.ROLLINGFILE.MaxBackupIndex.*)|\1|g' $ZK_HOME/conf/log4j.properties
sed -i -r 's|#autopurge|autopurge|g' $ZK_HOME/conf/zoo.cfg

initedfile="/data/cnscud.inited"
if [ ! -f "$initedfile" ]; then

  cd $ZK_HOME
  ./bin/zkServer.sh start

  ## waiting for zookeeper
  sleep 3

  echo "call init data now..."
  ##import data
  sh /cnscud/import.zk.sh

  ./bin/zkServer.sh stop

  ## mark
  echo "mark: init was finished!"
  touch "$initedfile"
else
  echo "data had inited, will not init again."
fi


echo "Starting Zookeeper in foreground mode..."
/usr/sbin/sshd
./bin/zkServer.sh start-foreground

# original mysql CMD
#/bin/sh -c #(nop) CMD ["/bin/sh" "-c" "/usr/sbin/sshd && bash /usr/bin/start-zk.sh"]
