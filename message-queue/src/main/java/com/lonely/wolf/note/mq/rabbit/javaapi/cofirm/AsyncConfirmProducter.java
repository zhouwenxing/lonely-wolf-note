package com.lonely.wolf.note.mq.rabbit.javaapi.cofirm;

import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/30
 * @since jdk1.8
 */
public class AsyncConfirmProducter {
    private static String QUEUE_NAME = "CONFIRM_QUEUE";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        String msg = "I'm a Async Confirm msg";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.addConfirmListener(new ConfirmListener() {
            /**
             * 已确认消息，即发送成功后回调
             * @param deliveryTag -唯一标识id（即发送消息时获取到的nextPublishSeqNo）
             * @param multiple - 是否批量确认，当multiple=true，表示<=deliveryTag的消息被批量确认，multiple=false，表示只确认了单条
             */
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {//成功回调
                System.out.println("收到确认消息了");
                //TODO 可以做一些想做的事
            }

            /**
             * 发送失败消息后回调
             * @param deliveryTag -唯一标识id（即发送消息时获取到的nextPublishSeqNo）
             * @param multiple - 是否批量确认，当multiple=true，表示<=deliveryTag的消息被批量确认，multiple=false，表示只确认了单条
             */
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {//失败回调
                if (multiple) {//批量确认，<deliveryTag的消息都发送失败
                    //TODO 消息重发？
                } else {//非批量，=deliveryTag的消息发送失败
                    //TODO 消息重发？
                }

            }
        });

        channel.confirmSelect();//开启确认模式
        for (int i=0;i<10;i++){//批量发送
            long nextSeqNo = channel.getNextPublishSeqNo();//获取发送消息的唯一标识(从1开始递增)
            //TODO 可以考虑把消息id存起来
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        }

        channel.close();
        conn.close();
    }
}
