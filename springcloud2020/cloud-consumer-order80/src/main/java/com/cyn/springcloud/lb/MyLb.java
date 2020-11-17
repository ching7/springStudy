package com.cyn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载方式
 *
 * @author chenyanan
 * Created by chenyanan on 2020/11/17
 */
@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement() {
        int current;
        int next;
        // 原子类-自旋锁
        do {
            current = this.atomicInteger.get();
            // 边界值保护
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("***used count :" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int currInstanceIndex = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(currInstanceIndex);
    }
}
