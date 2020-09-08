package com.cyn.strategypattern.service;

import com.cyn.strategypattern.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 文件描述
 *
 * @ProjectName: springboot-design-pattern
 * @Package: com.cyn.strategypattern.service
 * @Date 2020/9/8 15:20
 * @Author:
 * @Version: 1.0
 * @Description: note
 **/
@Service
public class SimpleContext {

    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String, Strategy> strategyMapIn) {
        // java8写法
        System.out.println("before construct : " + strategyMap);
        strategyMapIn.forEach(this.strategyMap::put);
        //strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
        System.out.println("after construct : " + strategyMap);
    }
    public Strategy getResource(String poolId) {
        return strategyMap.get(poolId);
    }

}
