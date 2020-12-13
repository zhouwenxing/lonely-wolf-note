package com.lonely.wolf.note.mq.rabbit.javaapi;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/5
 * @since jdk1.8
 */
public class TestRabbitProducter {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        Map<String, Object> headers = new HashMap<String, Object>(1);
        headers.put("name", "双子孤狼");

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
//                .deliveryMode(2)   // 2代表持久化
                .contentEncoding("UTF-8")  // 编码
//                .expiration("10000")  // TTL，过期时间
                .headers(headers) // 自定义属性
//                .priority(5) // 优先级，默认为5，配合队列的 x-max-priority 属性使用
                .messageId(String.valueOf(UUID.randomUUID()))
                .build();

        String msg = "Hello, RabbitMQ";
        // 声明队列（默认交换机AMQP default，Direct）
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare("TEST_QUEUE", false, false, false, null);

        // 发送消息
        // String exchange, String routingKey, BasicProperties props, byte[] body
        channel.basicPublish("", "TEST_QUEUE", properties, msg.getBytes());

        channel.close();
        conn.close();

    }
}
