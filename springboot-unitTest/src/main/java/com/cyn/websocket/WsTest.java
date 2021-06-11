package com.cyn.websocket;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-06-11
 */
public class WsTest {
    private static final Logger LOG = LoggerFactory.getLogger(WsTest.class);

    public static ThreadPoolExecutor WS_SEND_MESSAGE_POOL;
    public static ThreadFactory wsSendMessageThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("wsSendMessage-pool-%d").build();

    @Value("${ws.url:ws://172.31.98.88:3006/agent/}")
    private String rushWsUrl;

    private static WsClient CLIENT = null;

    private static String WS_URL;

    static {
        WS_SEND_MESSAGE_POOL = new ThreadPoolExecutor(
                20,
                100,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10000),
                wsSendMessageThreadFactory);
    }

    public static void sendMessage(String message) {
        LOG.info("Client向Server传参{}", message);
        CLIENT.send(message);
    }

    public void init() {
        WS_URL = rushWsUrl;
        connect();
    }

    private static void connect() {
        LOG.info("client connect server scoket url {} ", WS_URL);
        try {
            CLIENT = new WsClient(new URI(WS_URL));
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        CLIENT.connect();
        // 判断是否连接成功，未成功后面发送消息时会报错
        while (CLIENT.getReadyState().ordinal() == 0) {
            LOG.info("WsTest 连接中。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class WsClient extends WebSocketClient {

        public WsClient(URI serverUri) {
            super(serverUri);
        }

        @Override
        public void onOpen(ServerHandshake handshakedata) {
            LOG.info("WsTest 握手成功");
        }

        @Override
        public void onClose(int code, String reason, boolean remote) {
            LOG.info("WsTest 连接关闭");
            WS_SEND_MESSAGE_POOL.execute(() -> {
                LOG.info("尝试重连");
                connect();
            });
        }

        @Override
        public void onError(Exception ex) {
            LOG.info("WsTest 发生错误");
        }

        @Override
        public void onMessage(String message) {
            LOG.info("client get server message: " + message);
        }
    }
}
