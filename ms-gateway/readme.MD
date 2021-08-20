网关

##访问网址
    自动的: http://127.0.0.1:8900/ms-fundmain-service/user/queryBlogs?id=1000
    配置的: http://127.0.0.1:8900/fundmain/user/queryById?id=1000

    错误的: http://127.0.0.1:8900/fundmain/abc/aaa?id=1000

    停止微服务, 既可以看到fallback特性

    异常重试: http://127.0.0.1:8900/fundmain/exception/random
    异常重试: http://127.0.0.1:8900/fundmain/exception/must
    超时设置: http://127.0.0.1:8900/fundmain/exception/longtimeout
    超时设置: http://127.0.0.1:8900/fundmain/exception/smalltimeout
    
    限流测试: 使用PostMan  http://127.0.0.1:8900/fundmain/user/queryById?id=1000

    异常测试:
        根据accept 返回json格式:
        curl 'http://127.0.0.1:8900/fundmain/abc/aaa?id=1000' --header 'Accept: application/json'

    

## 测试的相关特性
* > 重试机制
* > Fallback - 错误: 服务宕机 
* > Fallback - 超时: 不设置缺省是1秒
* > Fallback - 指定 statusCodes 才能捕获, 否则只捕获网关的Exception  
* > 限流: 可以用 RequestRateLimiter  
* > 异常处理
* 错误过多: 未测试...

## Redis Rate Limiter
    redis-rate-limiter.burstCapacity: 20     这个参数表示突发容量,即每秒可以最大通过多少次请求
    redis-rate-limiter.replenishRate: 5      这个是令牌桶的补充速度，每秒往桶里边放几个令牌
    key-resolver: ‘#{@ipKeyResolver}’        这个就是用上KeyResolver的具体实现了，这里用spel表达式指定我写的那个ip限制类


## 网关文档
    https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#spring-cloud-circuitbreaker-filter-factory

## Todo 
    OK > 定制429的返回Response: https://juejin.cn/post/6933172840938078215
    OK > 输出DefaultFallback的Status Code: DefaultFallback已实现
    OK 如果获取被代理的请求的Response? -- 可以获取 Status, 其他没内容(否则网关的内存会被爆), 所以可以不拦截微服务的错误, 而在微服务侧做好错误处理
    OK 参考文章 Cache Response: https://stackoverflow.com/questions/65498001/spring-cloud-gateway-with-spring-cache-and-caffeine
    问题: Fallback: Status Code ? 404不行, NOT_FOUND可以!!??
    问题: Timeout: and no fallback has been configured?


## 类名 SpringCloudCircuitBreakerResilience4JFilterFactory    

## docker 命令

  Maven构建: mvn clean package docker:build

  手工构建: docker build -t cnscud/cavedemo/ms-gateway:v1.0.0 .

  运行: docker run --name msgateway -p 9001:9001 -d  --env ZK_HOSTS=172.18.0.145:2181 cnscud/cavedemo/ms-gateway:v1.0.0

  运行: docker run --name msgateway -p 8900:8900 -d  --env ZK_HOSTS=cd-zk1.cnscud.com:2181 cnscud/cavedemo/ms-gateway:v1.0.0

  停止: docker stop msgateway
  删除: docker rm msgateway
