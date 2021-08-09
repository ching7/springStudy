package com.cyn.controller;

import com.cyn.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 */
@RestController
public class SenderController {
    @Autowired
    private Sender sender;

    @RequestMapping("/sendMsg")
    public String send(String msg) {
        sender.send(msg);
        return msg;
    }
}
