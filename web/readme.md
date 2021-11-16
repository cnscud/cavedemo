Web 模块

## 测试
    设置HOSTS: 127.0.0.1 demo.cnscud.com
    访问 http://demo.cnscud.com:8000/
    
    阅读项目的README.md

## docker 命令

Maven构建: mvn  -DskipTests=true clean package

Maven构建(如果搭建了docker私服): mvn docker:build

手工构建: docker build -t cnscud/cavedemo-web:1.0 .

运行: docker run --name web -p 8000:8000 -d  --env ZK_HOSTS=cd-zk1.cnscud.com:2181 cnscud/cavedemo-web:1.0

停止: docker stop web
删除: docker rm web

