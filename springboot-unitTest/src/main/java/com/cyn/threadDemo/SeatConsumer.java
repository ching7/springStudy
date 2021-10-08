package com.cyn.threadDemo;

import com.cyn.bean.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-06
 */
public class SeatConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(SeatConsumer.class);

    public void init() {
        SeatQueueCache.pool.execute(new Runnable() {
            @Override
            public void run() {
//                while (true) {
//                    UserBean user = SeatQueueCache.freeSeatQueue.poll();
//                    if (user != null) {
//                        System.out.println(SeatQueueCache.freeSeatQueue.toString());
//                        // 有空闲坐席，消费排队信息，通知CTI
//                        // 1 获取排队时间最长的队列
//                        System.out.println("消费：" + user);
//                    } else {
//                        // 线程暂停1s
//                        try {
//                            TimeUnit.SECONDS.sleep(1);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("等待空闲坐席。。。");
//                    }
//                }
            }
        });
    }
}
