网关

##访问网址
    自动的: http://127.0.0.1:8900/ms-fundmain-service/user/queryBlogs?id=1000
    配置的: http://127.0.0.1:8900/fundmain/user/queryById?id=1000

    错误的: http://127.0.0.1:8900/fundmain/abc/aaa?id=1000

    停止微服务, 既可以看到fallback特性

    异常重试: http://127.0.0.1:8900/fundmain/exception/random
    超时设置: http://127.0.0.1:8900/fundmain/exception/longtimeout
    超时设置: http://127.0.0.1:8900/fundmain/exception/smalltimeout
    
    限流测试: 使用PostMan  http://127.0.0.1:8900/fundmain/user/queryById?id=1000


## 特性
* > 重试机制
* > Fallback - 错误: 服务宕机 
* > Fallback - 超时: 不设置缺省是1秒
* > 限流: 可以用 RequestRateLimiter  
* 异常处理?
* 错误过多: 未测试...

## Redis Rate Limiter
    redis-rate-limiter.burstCapacity: 20     这个参数表示突发容量,即每秒可以最大通过多少次请求
    redis-rate-limiter.replenishRate: 5      这个是令牌桶的补充速度，每秒往桶里边放几个令牌
    key-resolver: ‘#{@ipKeyResolver}’        这个就是用上KeyResolver的具体实现了，这里用spel表达式指定我写的那个ip限制类