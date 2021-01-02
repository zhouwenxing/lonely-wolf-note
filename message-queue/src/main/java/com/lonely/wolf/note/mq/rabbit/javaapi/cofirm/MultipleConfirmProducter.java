package com.lonely.wolf.note.mq.rabbit.javaapi.cofirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/30
 * @since jdk1.8
 */
public class MultipleConfirmProducter {
    private static String QUEUE_NAME = "CONFIRM_QUEUE";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();
        String msg = "I'm a Multiple Confirm msg";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.confirmSelect();//开启确认模式
        //批量发送
        for (int i=0;i<10;i++){
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }
        try{
            channel.waitForConfirmsOrDie();//消息发送异常后，channel会被关闭，无法继续发送消息
        }catch (IOException e){//只要有1条消息未被确认，就会抛出异常
            e.printStackTrace();
            System.out.println("有消息发送失败了");
        }
        channel.close();
        conn.close();
    }
}
