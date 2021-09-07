package com.cyn.threadDemo;

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
    public void addSeatQueue(String seatNo){
        boolean add = SeatQueueCache.freeSeatQueue.add(seatNo);
        System.out.println(add);
    }
}
