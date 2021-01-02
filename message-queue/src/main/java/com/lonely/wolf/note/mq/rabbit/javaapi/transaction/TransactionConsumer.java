package com.lonely.wolf.note.mq.rabbit.javaapi.transaction;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/5
 * @since jdk1.8
 */
public class TransactionConsumer {
    private static String QUEUE_NAME = "TRANSACTION_QUEUE";
    public static void main(String[] args) throws Exception{
        //1.声明连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");

        //2.建立连接
        Connection conn = factory.newConnection();

        //3.创建消息通道
        Channel channel = conn.createChannel();

        //4.声明队列（默认交换机AMQP default，Direct）
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" Waiting for message....");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("收到消息: " + new String(body, "UTF-8"));
            }
        };
        // 开始获取消息
        // String queue, boolean autoAck, Consumer callback
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
