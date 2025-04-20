package org.yinxiao.nothing.utils;

/**
 * @Title: TokenBlacklist
 * @Author: 江河三千里
 * @Package: org.yinxiao.nothing.utils
 * @Date: 2025/4/20 16:39
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Token 黑名单类，使用 Redis 存储失效的 Token
 */
@Component
public class TokenBlacklist {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String BLACKLIST_KEY_PREFIX = "token:blacklist:";

    public void addToBlacklist(String token, long expiration) {
        String key = BLACKLIST_KEY_PREFIX + token;
        redisTemplate.opsForValue().set(key, "blacklisted", expiration, TimeUnit.MILLISECONDS);
    }

    public boolean isBlacklisted(String token) {
        String key = BLACKLIST_KEY_PREFIX + token;
        return redisTemplate.hasKey(key);
    }
}