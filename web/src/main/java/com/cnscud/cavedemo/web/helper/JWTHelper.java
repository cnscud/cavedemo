package com.cnscud.cavedemo.web.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cnscud.xpower.cache.IRedis;
import com.cnscud.xpower.cache.IRedisCluster;
import com.cnscud.xpower.cache.impl.RedisAutoConfigCacheFactory;
import com.cnscud.xpower.cache.impl.RedisClusterAutoConfigCacheFactory;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JWT Utils.
 * 可以考虑移动到服务里.
 *
 * @author Felix Zhang 2021-08-06 20:15
 * @version 1.0.0
 */
@Component
public class JWTHelper {

    static Logger logger = LoggerFactory.getLogger(JWTHelper.class);
    //static IRedisCluster redis = RedisClusterAutoConfigCacheFactory.getInstance().getCache("redis.cluster.test");
    //为了测试方便, 此时使用redis单个实例
    static IRedis redis =  RedisAutoConfigCacheFactory.getInstance().getCache("redis.test");


    // 过期时间7天
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    public static String redisKey4UserId(int userid){
        return "user-login-" + userid;
    }

    /**
     * 生成签名,7days后过期
     *
     * @param userid user id
     * @return 加密的token
     */
    public static String sign(Integer userid, String access_level) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        String userJwtSecretKey = redisKey4UserId(userid);

        if (redis.exists(userJwtSecretKey)) {
            redis.delete(userJwtSecretKey);
        }

        String secret = UUID.randomUUID().toString();
        Algorithm algorithm = Algorithm.HMAC256(secret);
        redis.set(userJwtSecretKey, secret, EXPIRE_TIME, TimeUnit.SECONDS);
        logger.info(userJwtSecretKey + "&" + secret);

        // 附带openid信息
        return JWT.create()
                .withClaim("userid", userid)
                .withClaim("access_level", access_level)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static void signout(Integer userid){
        String userJwtSecretKey = redisKey4UserId(userid);

        if (redis.exists(userJwtSecretKey)) {
            redis.delete(userJwtSecretKey);
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {

            int userid = JWTHelper.getUserid(token);
            String access_level = getAccessLevel(token);

            String userJwtSecretKey = redisKey4UserId(userid);

            String secret = redis.get(userJwtSecretKey);
            //例如被清理了
            if(secret == null){
                return false;
            }

            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userid", userid)
                    .withClaim("access_level", access_level)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
        }
        catch (JWTVerificationException exception) {
            return false;
        }
        return true;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的 userid
     */
    public static int getUserid(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("userid").asInt();
    }

    public static String getAccessLevel(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("access_level").asString();
    }

}
