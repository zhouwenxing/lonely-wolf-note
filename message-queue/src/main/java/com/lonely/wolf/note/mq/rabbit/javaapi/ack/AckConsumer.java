package com.lonely.wolf.note.mq.rabbit.javaapi.ack;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/5
 * @since jdk1.8
 */
public class AckConsumer {
    private static String QUEUE_NAME = "ACK_QUEUE";
    public static void main(String[] args) throws Exception{
        //1.声明连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");

        //2.建立连接
        Connection conn = factory.newConnection();
        //3.创建消息通道
        Channel channel = conn.createChannel();
        //4.声明队列（默认交换机AMQP default，Direct）
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" 等待接收消息...");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                System.out.println("收到消息: " + new String(body, "UTF-8"));
                Map<String,Object> map = properties.getHeaders();
                String ackType = map.get("ackType").toString();
                if (ackType.equals("ack")){//手动应答
                    channel.basicAck(envelope.getDeliveryTag(),true);
                }else if(ackType.equals("reject-single")){//拒绝单条消息
                    //拒绝消息。requeue参数表示消息是否重新入队
                    channel.basicReject(envelope.getDeliveryTag(),false);
//                    channel.basicNack(envelope.getDeliveryTag(),false,false);
                }else if (ackType.equals("reject-multiple")){//拒绝多条消息
                    //拒绝消息。multiple参数表示是否批量拒绝，为true则表示<deliveryTag的消息都被拒绝
                    channel.basicNack(envelope.getDeliveryTag(),true,false);
                }
            }
        };

        //开始获取消息,第二个参数 autoAck表示是否开启自动应答
        channel.basicConsume(QUEUE_NAME, false, consumer);
    }
}
