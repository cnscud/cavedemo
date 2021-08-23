FROM zookeeper:3.6

LABEL OG=cnscud.com
LABEL maintainer="Felix Zhang<cnscud@gmail.com>"
LABEL reference="https://github.com/cnscud"

## my entrypoint script
ADD cnscud-docker-entrypoint.sh /


#ADD import.zk.sh /cnscud/
#ADD kafka.conf /cnscud/
#ADD mysql.cavedemo.conf /cnscud/
#ADD redis.test.conf /cnscud/

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

## declare the volumen for init data
VOLUME /init.data

## declare the port
EXPOSE 2181

## ===================================

# for init data before launch
# CMD ["/bin/sh", "-c", "bash /startup-wurstmeister.sh"]

## from wurstmeister zookeeper 3.4.3 as reference
#CMD ["/bin/sh","-c","/usr/sbin/sshd && bash /usr/bin/start-zk.sh"]

## ===================================

## from official zookeeper as reference
# ENTRYPOINT ["/docker-entrypoint.sh"]
# CMD ["zkServer.sh" "start-foreground"]

ENTRYPOINT ["/cnscud-docker-entrypoint.sh"]
CMD ["zkServer.sh","start-foreground"]
