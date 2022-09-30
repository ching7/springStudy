package com.cyn.controller;

import cn.hutool.core.date.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ConvertingCursor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @author chenyanan
 */
@RestController
public class SpringDataRedisTestController {

    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * description: testRedisSet 测试redis设置缓存<br>
     *
     * @return java.lang.String
     * @version: 1.0 <br>
     * @date: 2022/7/21 21:59 <br>
     * @author: William <br>
     */
    @GetMapping("redisSet")
    public String testRedisSet() {
        redisTemplate.opsForValue().set("test:redis:userName" + UUID.randomUUID(),
                "张三" + UUID.randomUUID(), 120,
                TimeUnit.SECONDS);
        return "OK";
    }


    @GetMapping("redisGet")
    public String testRedisGet() {
        String name = redisTemplate.opsForValue().get("test:redis:userName");
        return name;
    }

    /**
     * description: testRedisSet 测试redis设置缓存<br>
     *
     * @return java.lang.String
     * @version: 1.0 <br>
     * @date: 2022/7/21 21:59 <br>
     * @author: William <br>
     */
    @GetMapping("redisKeys")
    public String testRedisKeys() {
        StopWatch watch = new StopWatch();
        watch.start("redisKeys");
        Set<String> keys = redisTemplate.keys("test:redis:userName*");

        watch.stop();
        System.out.println(watch.prettyPrint());
        assert keys != null;
        keys.forEach(System.out::println);
        return "OK";
    }


    @GetMapping("redisScan")
    public String testRedisScan() {
        StopWatch watch = new StopWatch();
        watch.start("redisScan");
        ScanOptions options = ScanOptions.scanOptions()
                //这里指定每次扫描key的数量(很多博客瞎说要指定Integer.MAX_VALUE，这样的话跟        keys有什么区别？)
                .count(1000)
                .match("test:redis:userName*").build();

        RedisSerializer<String> redisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();
        Cursor cursor = (Cursor) redisTemplate.executeWithStickyConnection(redisConnection ->
                new ConvertingCursor<>(redisConnection.scan(options), redisSerializer::deserialize));
        watch.stop();
        System.out.println(watch.prettyPrint());
        List<String> result = new ArrayList<>();
        while (cursor.hasNext()) {
            result.add(cursor.next().toString());
        }
        result.forEach(System.out::println);
        cursor.close();

        return "1";
    }
}