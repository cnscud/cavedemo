FROM wurstmeister/zookeeper

LABEL OG=cnscud.com

ADD startup.sh /
ADD import.zk.sh /cnscud/
ADD kafka.conf /cnscud/
ADD mysql.cavedemo.conf /cnscud/
ADD redis.test.conf /cnscud/


EXPOSE 2181

# for init data before launch
CMD ["/bin/sh", "-c", "bash /startup.sh"]
#CMD ["/bin/bash"]
#CMD ["/bin/sh","-c","/usr/sbin/sshd && bash /usr/bin/start-zk.sh"]
