package com.lonely.wolf.note.mq.rabbit.javaapi.cofirm;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/30
 * @since jdk1.8
 */
public class SingleConfirmProducter {
    private static String QUEUE_NAME = "CONFIRM_QUEUE";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        String msg = "I'm a Single Confirm msg";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.confirmSelect();//开启确认模式
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        if (channel.waitForConfirms()){//wait.ForConfirms(long time)
            System.out.println("消息确认发送成功");
        }
        channel.close();
        conn.close();
    }
}
