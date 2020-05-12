package com.cyn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消息队列的测试类
 *
 * @author chenyn
 * @version 1.0
 * @date 2019/10/22 0:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class QueueTest {
    @Autowired
    private Sender sender;

    /**
     * 测试消息队列
     */
    @Test
    public void sendMsg() throws InterruptedException {
        int count = 10;
        while (count > 1) {
            Thread.sleep(1000);
            this.sender.send("Hello rabbmit ");
            count--;
        }
    }
}
