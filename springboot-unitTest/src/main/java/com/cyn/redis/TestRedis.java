package com.cyn.redis;

import com.alibaba.fastjson.JSONObject;
import com.cyn.bean.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-01
 */
@RestController
public class TestRedis {

    private static RedisUtils redisUtils;

    static {
        try {
            redisUtils = RedisUtils.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("redis/addObj")
    public void addRedis(Integer expireTime) {
        UserBean u = new UserBean("wanger", "13");
        String key = UUID.randomUUID().toString();
        Map seatQueueMap = JSONObject.parseObject(JSONObject.toJSONString(u), Map.class);
        redisUtils.hPutAll(key, seatQueueMap);
        redisUtils.hPutAll(key+"_2", seatQueueMap);

        redisUtils.expire(key, expireTime.longValue(), TimeUnit.SECONDS);

    }
}
