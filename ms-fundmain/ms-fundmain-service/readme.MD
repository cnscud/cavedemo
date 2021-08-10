
如果使用 -> 缺省数据源说明:

1. 使用application-singledb.yml 
2. FundMainApplication 里开启:
 
   @SpringBootApplication
   @EnableTransactionManagement
   @MapperScan(basePackages = {"com.cnscud.cavedemo.fundmain.dao"})


## 测试时访问网址

   数据库: http://127.0.0.1:9001/user/queryBlogs?id=1001
   ZK: http://127.0.0.1:9001/zk/test
   Redis: http://127.0.0.1:9001/redis/test
   
   异常统一处理: http://127.0.0.1:9001/exception/must