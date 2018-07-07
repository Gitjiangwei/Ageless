/*package com.ageless.service.impl;

import com.alipay.api.internal.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        this.setObject(key, value, null);
    }

    public void setString(String key, String value, Long time) {
        this.setObject(key, value, time);
    }

    public void setList(String key, List listValue) {
        this.setObject(key, listValue, null);
    }

    public void setObject(String key, Object value, Long time) {
        //Redis支持五种数据类型：
        // string（字符串），hash（哈希），list（列表），set（集合）及zset(sorted set：有序集合)。
        if (StringUtils.isEmpty(key) || value == null) {
            return;
        }
        if (value instanceof String) {
            String strValue = (String) value;
            stringRedisTemplate.opsForValue().set(key, strValue);
            if (time != null) {
                stringRedisTemplate.opsForValue().set(key, strValue, time, TimeUnit.SECONDS);
            }
            return;
        }
        if (value instanceof List) {
            List<String> listValue = (List) value;
            for (String string : listValue) {
                stringRedisTemplate.opsForList().leftPush(key, string);

            }
            return;
        }
    }
    public String getStringKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}*/
