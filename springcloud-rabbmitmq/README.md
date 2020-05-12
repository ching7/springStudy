## RabbitMQ 基础DEMO

#### RabbitMQ的安装和使用

1. 安装Erlang，下载地址：http://erlang.org/download/otp_win64_21.3.exe

![img](http://www.macrozheng.com/images/arch_screen_53.png)

2. 安装RabbitMQ，下载地址：https://dl.bintray.com/rabbitmq/all/rabbitmq-server/3.7.14/rabbitmq-server-3.7.14.exe

![img](http://www.macrozheng.com/images/arch_screen_54.png)

3. 安装完成后，进入RabbitMQ安装目录下的sbin目录

![img](http://www.macrozheng.com/images/arch_screen_55.png)

4. 在地址栏输入cmd并回车启动命令行，然后输入以下命令启动管理功能：

```
.\rabbitmq-plugins.bat enable rabbitmq_management
```

![img](http://www.macrozheng.com/images/arch_screen_56.png)

5. 访问地址查看是否安装成功：http://localhost:15672/

![img](http://www.macrozheng.com/images/arch_screen_57.png)

6. 输入账号密码并登录：guest guest

#### RabbitMQ的消息模型

![img](http://www.macrozheng.com/images/arch_screen_52.png)

| 标志 | 中文名     | 英文名   | 描述                                             |
| ---- | ---------- | -------- | ------------------------------------------------ |
| P    | 生产者     | Producer | 消息的发送者，可以将消息发送到交换机             |
| C    | 消费者     | Consumer | 消息的接收者，从队列中获取消息进行消费           |
| X    | 交换机     | Exchange | 接收生产者发送的消息，并根据路由键发送给指定队列 |
| Q    | 队列       | Queue    | 存储从交换机发来的消息                           |
| type | 交换机类型 | type     | direct表示直接根据路由键（orange/black）发送消息 |