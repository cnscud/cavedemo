Web 模块


## docker 命令

Maven构建: mvn  -DskipTests=true clean package

Maven构建(如果搭建了docker私服): mvn docker:build

手工构建: docker build -t cnscud/cavedemo-mq-consumers:1.0 .

运行: docker run --name mq-consumers -d  --env ZK_HOSTS=cd-zk1.cnscud.com:2181 cnscud/cavedemo-mq-consumers:1.0

停止: docker stop mq-consumers
删除: docker rm mq-consumers

