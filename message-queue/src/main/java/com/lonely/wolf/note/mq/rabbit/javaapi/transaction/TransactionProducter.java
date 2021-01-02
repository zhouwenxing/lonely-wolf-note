package com.lonely.wolf.note.mq.rabbit.javaapi.transaction;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 开启事务的生产者
 * @author zwx
 * @version 1.0
 * @date 2020/12/28
 * @since jdk1.8
 */
public class TransactionProducter {
    private static String QUEUE_NAME = "TRANSACTION_QUEUE";
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        String msg = "Hello, RabbitMQ";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        try {
            channel.txSelect();//开启事务
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            channel.txCommit();//提交事务
        }catch (Exception e){
            channel.txRollback();//消息回滚
        }
        channel.close();
        conn.close();
    }
}
