# 微服务

### 如果使用 -> 缺省数据源说明:

1. 使用application-singledb.yml 
2. FundMainApplication 里开启:
 
   @SpringBootApplication
   @EnableTransactionManagement
   @MapperScan(basePackages = {"com.cnscud.cavedemo.fundmain.dao"})


## 测试时访问网址

   数据库: http://127.0.0.1:9001/user/queryById?id=1001
   ZK: http://127.0.0.1:9001/zk/test
   Redis: http://127.0.0.1:9001/redis/test
   队列: http://127.0.0.1:9001/mq/visituser?userid=1001 (消费者会同时收到一条消息)
   
   异常统一处理: http://127.0.0.1:9001/exception/must

## docker 命令
   Maven构建: mvn -DskipTests=true  clean package docker:build

   手工构建: docker build -t cnscud/cavedemo-ms-fundmain-service:1.0 .

   运行: docker run --name msfs -p 9001:9001 -d  --env ZK_HOSTS=172.18.0.124:2181 cnscud/cavedemo-ms-fundmain-service:1.0

   运行: docker run --name msfs -p 9001:9001 -d  --env ZK_HOSTS=cd-zk1.cnscud.com:2181 cnscud/cavedemo-ms-fundmain-service:1.0

   停止: docker stop msfs
   删除: docker rm msfs




