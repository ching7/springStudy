package com.cyn.service.event;

import com.cyn.event.Eventlistent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-08-09
 */
@Service
@Slf4j
public class EventService {
    /**
     * 监听用户注册事件,执行发放优惠券逻辑
     */
    @EventListener
    public void addCoupon(Eventlistent event) {
        log.info("给用户[{}]发放优惠券", event.getUsername());
    }
}
