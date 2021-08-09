package com.cyn.service.event;

import com.cyn.event.Eventlistent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 * 实现ApplicationListener<Event>的方式
 */
@Service
@Slf4j
public class EmailService  implements ApplicationListener<Eventlistent> {
    @Override
    public void onApplicationEvent(Eventlistent eventlistent) {
        log.info("给用户[{}]发送邮件", eventlistent.getUsername());
    }
}
