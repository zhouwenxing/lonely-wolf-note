package com.lonely.wolf.note.mq.rabbit.javaapi.ack;

import com.rabbitmq.client.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/1/2
 * @since jdk1.8
 */
public class AckProducter {
    private static String QUEUE_NAME = "ACK_QUEUE";//队列
    private static String EXCHANGE_NAME = "ACK_EXCHANGE";//交换机
    private static String ROUTEING_KEY = "test";
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        Map<String, Object> headers = new HashMap<String, Object>(1);
        headers.put("ackType", "ack");//请应答
//        headers.put("ackType", "reject-single");//请单条拒绝
//        headers.put("ackType", "reject-multiple");//请多条拒绝

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .contentEncoding("UTF-8")  // 编码
                .headers(headers) // 自定义属性
                .messageId(String.valueOf(UUID.randomUUID()))
                .build();

        String msg = "I'm a ack message";
        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,false);
        //队列和交换机进行绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTEING_KEY);
        // 发送消息
        channel.basicPublish(EXCHANGE_NAME, ROUTEING_KEY, properties, msg.getBytes());

        channel.close();
        conn.close();

    }
}
