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
    问题: Fallback: Status Code ? 404不行, NOT_FOUND可以!!??
    问题: Timeout: and no fallback has been configured?
    问题: 如果获取被代理的请求的Response?


## 类名 SpringCloudCircuitBreakerResilience4JFilterFactory    
