
单数据源说明:

1. 使用application-singledb.yml
2. FundMainApplication 里开启:
 
   @SpringBootApplication
   @EnableTransactionManagement
   @MapperScan(basePackages = {"com.cnscud.cavedemo.fundmain.dao"})
