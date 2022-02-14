package test.controller;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-12-03
 */
public class LogIpConfig extends ClassicConverter {
    private static final Logger logger = LoggerFactory.getLogger(LogIpConfig.class);
    private static String webIP;

    @Override
    public String convert(ILoggingEvent event) {
        try {
            IpConfiguration bean = SpringBeanUtils.getBean(IpConfiguration.class);
            webIP = InetAddress.getLocalHost().getHostAddress() + ":" + bean.getPort();
        } catch (UnknownHostException e) {
            logger.error("获取日志Ip异常", e);
            webIP = null;
        }
        return webIP;
    }
}