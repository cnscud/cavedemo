Web 模块


## docker 命令

Maven构建: mvn clean package docker:build

手工构建: docker build -t cnscud/cavedemo/web:v1.0.0 .

运行: docker run --name web -p 8000:8000 -d  --env ZK_HOSTS=cd-zk1.cnscud.com:2181 cnscud/cavedemo/web:v1.0.0

停止: docker stop web
删除: docker rm web

