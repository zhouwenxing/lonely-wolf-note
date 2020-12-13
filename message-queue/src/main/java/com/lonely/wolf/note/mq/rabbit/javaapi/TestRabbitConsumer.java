package com.lonely.wolf.note.mq.rabbit.javaapi;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/5
 * @since jdk1.8
 */
public class TestRabbitConsumer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");

        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        // 声明队列（默认交换机AMQP default，Direct）
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare("TEST_QUEUE", false, false, false, null);
        System.out.println(" Waiting for message....");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("收到消息: " + new String(body, "UTF-8") + "，当前消息ID为：" + properties.getMessageId());
                System.out.println("收到自定义属性："+ properties.getHeaders().get("name"));
            }
        };

        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        channel.basicConsume("TEST_QUEUE", true, consumer);

    }
}
