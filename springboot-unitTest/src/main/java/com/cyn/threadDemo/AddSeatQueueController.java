package com.cyn.threadDemo;

import com.cyn.bean.UserBean;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-09-06
 */
@RestController
public class AddSeatQueueController {
    @RequestMapping("/addSeatQueue")
    public void addSeatQueue(UserBean user) {
        boolean add = SeatQueueCache.freeSeatQueue.add(user);
        System.out.println(add);
    }

    @RequestMapping("/removeSeatQueue")
    public void removeSeatQueue(UserBean user) {
        boolean add = SeatQueueCache.freeSeatQueue.remove(user);
        System.out.println(add);
    }




}
