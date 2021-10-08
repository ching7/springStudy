package com.cyn.threadDemo;

import com.cyn.bean.UserBean;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-06
 */
public class SeatQueueCache {
    public static ThreadPoolExecutor pool;

    public static Queue<UserBean> freeSeatQueue = new ConcurrentLinkedQueue<>();

    static {
        ThreadFactory seatQueueThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("SeatQueue-pool-%d").build();
        pool = new ThreadPoolExecutor(
                20,
                100,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(500),
                seatQueueThreadFactory);
    }
}
